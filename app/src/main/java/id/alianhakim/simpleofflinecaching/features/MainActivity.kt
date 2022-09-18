package id.alianhakim.simpleofflinecaching.features

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import id.alianhakim.simpleofflinecaching.data.Post
import id.alianhakim.simpleofflinecaching.features.posts.ui.PostViewModel
import id.alianhakim.simpleofflinecaching.utils.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var posts by remember { mutableStateOf(listOf<Post>()) }
            var isLoading by remember { mutableStateOf(false) }
            var isError by remember { mutableStateOf(false) }
            var errorMessage by remember { mutableStateOf("") }
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                viewModel.posts.observe(this) { result ->
                    posts = result.data ?: emptyList()
                    isLoading = result is Resource.Loading && result.data.isNullOrEmpty()
                    isError = result is Resource.Error && result.data.isNullOrEmpty()
                    errorMessage = result.throwable?.localizedMessage ?: ""
                }
                if (isLoading) {
                    CircularProgressIndicator()
                }
                if (isError) {
                    Text(text = errorMessage)
                }
                if (!isLoading && isError) {
                    PostList(posts = posts)
                }
            }
        }
    }
}

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn {
        itemsIndexed(items = posts) { _, item ->
            PostItem(post = item)
        }
    }
}

@Composable
fun PostItem(modifier: Modifier = Modifier, post: Post) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            AsyncImage(
                model = "https://via.placeholder.com/150x150",
                contentDescription = "image placeholder"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = post.id.toString(), style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = post.title, modifier = Modifier.fillMaxWidth())
                Text(
                    text = post.body,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}