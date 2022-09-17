package id.alianhakim.simpleofflinecaching.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.alianhakim.simpleofflinecaching.databinding.ActivityMainBinding
import id.alianhakim.simpleofflinecaching.features.address.ui.AddressAdapter
import id.alianhakim.simpleofflinecaching.features.address.ui.AddressViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val addressAdapter by lazy { AddressAdapter() }
    private val viewModel by viewModels<AddressViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            recyclerView.apply {
                adapter = addressAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

        viewModel.addresses.observe(this) {
            addressAdapter.submitList(it)
        }
    }
}