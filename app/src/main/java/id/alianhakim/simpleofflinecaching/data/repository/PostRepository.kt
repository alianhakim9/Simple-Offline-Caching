package id.alianhakim.simpleofflinecaching.data.repository

import androidx.room.withTransaction
import id.alianhakim.simpleofflinecaching.data.local.PostDatabase
import id.alianhakim.simpleofflinecaching.data.remote.RemoteApi
import id.alianhakim.simpleofflinecaching.utils.networkBoundResource
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val db: PostDatabase,
    private val api: RemoteApi
) {
    val postDao = db.postDao()
    fun getPosts() = networkBoundResource(
        query = {
            postDao.getPosts()
        },
        fetch = {
            // get data from network
            api.getPosts()
        },
        saveFetchResult = { posts ->
            db.withTransaction {
                postDao.delete()
                postDao.insert(posts)
            }
        }
    )
}