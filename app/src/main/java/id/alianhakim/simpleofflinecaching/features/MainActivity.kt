package id.alianhakim.simpleofflinecaching.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.alianhakim.simpleofflinecaching.databinding.ActivityMainBinding
import id.alianhakim.simpleofflinecaching.features.posts.ui.PostAdapter
import id.alianhakim.simpleofflinecaching.features.posts.ui.PostViewModel
import id.alianhakim.simpleofflinecaching.utils.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val postAdapter by lazy { PostAdapter() }
    private val viewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            recyclerView.apply {
                adapter = postAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
        viewModel.posts.observe(this) { result ->
            postAdapter.submitList(result.data)
            binding.progressBar.isVisible =
                result is Resource.Loading && result.data.isNullOrEmpty()
            binding.textViewError.isVisible =
                result is Resource.Error && result.data.isNullOrEmpty()
            binding.textViewError.text = result.throwable?.localizedMessage
        }
    }
}