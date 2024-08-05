package com.example.finance.domain.repository

import android.content.Context
import com.example.finance.data.AppDatabase
import com.example.finance.domain.entities.EntityUserFinance
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RepositoryUserFinance(context: Context) {

    private val db = AppDatabase.getDatabase(context).userFinanceDao()
    val listUserFinance: Flow<List<EntityUserFinance>> = db.getAllUserFinance()

    fun getUserFinanceById(id: String) = db.getUserFinanceById(id)

    suspend fun saveUserFinance(entityUserFinance: EntityUserFinance) = withContext(IO) {
        db.saveUserFinance(entityUserFinance)
    }

    suspend fun updateUserFinance(entityUserFinance: EntityUserFinance) = withContext(IO) {
        db.updateUserFinance(entityUserFinance)
    }

    suspend fun deleteUserFinance(entityUserFinance: EntityUserFinance) = withContext(IO) {
        db.deleteUserFinance(entityUserFinance)
    }

}