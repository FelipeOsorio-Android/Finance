package com.example.finance.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finance.domain.dao.DaoUserFinance
import com.example.finance.domain.entities.EntityUserFinance

@Database(entities = [EntityUserFinance::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userFinanceDao(): DaoUserFinance

    companion object {
        private const val DATABASE_NAME = "finance_db"
        private lateinit var appDatabase: AppDatabase

        fun getDatabase(context: Context): AppDatabase {
            if (!::appDatabase.isInitialized) {
                appDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return appDatabase
        }
    }

}