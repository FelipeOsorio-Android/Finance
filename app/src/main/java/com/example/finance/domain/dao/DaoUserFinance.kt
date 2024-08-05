package com.example.finance.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.finance.domain.entities.EntityUserFinance
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoUserFinance {

    @Query(value = "SELECT * FROM EntityUserFinance")
    fun getAllUserFinance(): Flow<List<EntityUserFinance>>

    @Query(value = "SELECT * FROM EntityUserFinance WHERE id = :id")
    fun getUserFinanceById(id: String): Flow<EntityUserFinance?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserFinance(entityUserFinance: EntityUserFinance)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserFinance(entityUserFinance: EntityUserFinance)

    @Delete
    suspend fun deleteUserFinance(entityUserFinance: EntityUserFinance)


}