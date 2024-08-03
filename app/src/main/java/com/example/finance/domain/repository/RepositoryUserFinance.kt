package com.example.finance.domain.repository

import android.content.Context
import com.example.finance.data.AppDatabase
import com.example.finance.domain.entities.EntityUserFinance
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RepositoryUserFinance(context: Context) {

    private val db = AppDatabase.getDatabase(context).userFinanceDao()
    val list: Flow<List<EntityUserFinance>> = db.getAllFinance()

    fun getUserFinance(id: String) = db.getUserFinance(id)

    suspend fun saveUserFinance(entityUserFinance: EntityUserFinance) = withContext(IO) {
        db.saveUserFinance(entityUserFinance)
    }

}