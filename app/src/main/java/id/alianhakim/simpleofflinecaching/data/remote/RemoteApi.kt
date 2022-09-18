package id.alianhakim.simpleofflinecaching.data.remote

import id.alianhakim.simpleofflinecaching.data.Post
import retrofit2.http.GET

interface RemoteApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}