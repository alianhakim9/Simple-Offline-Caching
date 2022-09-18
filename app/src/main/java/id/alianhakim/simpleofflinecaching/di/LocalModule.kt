package id.alianhakim.simpleofflinecaching.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.alianhakim.simpleofflinecaching.data.local.PostDao
import id.alianhakim.simpleofflinecaching.data.local.PostDatabase
import id.alianhakim.simpleofflinecaching.utils.Constants.DATABASE_NAME
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun providePostDatabase(
        @ApplicationContext context: Context
    ): PostDatabase {
        return Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePostDao(database: PostDatabase): PostDao {
        return database.postDao()
    }
}