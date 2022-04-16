package com.example.roomrelationsonetomany

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@androidx.room.Database(entities = [UserModel::class, AccountModel::class],exportSchema = false, version = 1)
abstract class Database : RoomDatabase() {
   abstract fun usersDao() : UsersDao
   companion object {
        @Volatile
        private var Instance: Database? = null

        fun getDatabase(context: Context, scope: CoroutineScope):
                Database= Instance ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                Database::class.java,
                "Database"
            ).addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    scope.launch {
                        Instance
                            ?.usersDao()
                    }
                }
            }).build()

            Instance = instance

            instance
        }
    }
}