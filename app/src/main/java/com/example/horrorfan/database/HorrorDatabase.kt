package com.example.horrorfan.database

import android.content.Context
import androidx.room.*

@Database(entities = [Movies::class, Series::class, Characters::class], version = 1, exportSchema = false)
abstract class HorrorDatabase : RoomDatabase() {

    abstract val horrorDatabaseDao: HorrorDao

    companion object {
        @Volatile
        private var INSTANCE: HorrorDatabase? = null

        fun getInstance(context: Context): HorrorDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HorrorDatabase::class.java,
                        "Movie").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}