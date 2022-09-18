package id.alianhakim.simpleofflinecaching.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.alianhakim.simpleofflinecaching.data.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: List<Post>)

    @Query("SELECT * FROM post")
    fun getPosts(): Flow<List<Post>>

    @Query("DELETE FROM post")
    suspend fun delete()
}