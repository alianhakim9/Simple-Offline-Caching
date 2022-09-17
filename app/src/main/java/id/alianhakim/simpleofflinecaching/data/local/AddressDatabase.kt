package id.alianhakim.simpleofflinecaching.data.local

import androidx.room.RoomDatabase


abstract class AddressDatabase : RoomDatabase() {
    abstract fun addressDao(): AddressDao
}