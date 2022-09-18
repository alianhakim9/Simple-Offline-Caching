package id.alianhakim.simpleofflinecaching.features.posts.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.alianhakim.simpleofflinecaching.data.repository.PostRepository
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    repository: PostRepository
) : ViewModel() {
    val posts = repository.getPosts().asLiveData()
}