package com.example.finance.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class EntityUserFinance(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val type: String,
    val value: Double,
    val description: String,
    val date: String,
    val category: String
)