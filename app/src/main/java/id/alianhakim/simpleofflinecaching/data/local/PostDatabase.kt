package id.alianhakim.simpleofflinecaching.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import id.alianhakim.simpleofflinecaching.data.Post


@Database(
    entities = [Post::class],
    version = 1
)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}