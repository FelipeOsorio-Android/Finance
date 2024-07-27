package com.example.finance.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finance.domain.entities.EntityUserFinance
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoUserFinance {

    @Query(value = "SELECT * FROM EntityUserFinance")
    fun getAllFinance(): Flow<List<EntityUserFinance>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserFinance(entityUserFinance: EntityUserFinance)
}