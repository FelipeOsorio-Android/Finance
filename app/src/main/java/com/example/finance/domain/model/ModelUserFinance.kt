package com.example.finance.domain.model

import java.util.UUID


data class ModelUserFinance(
    val id: String = UUID.randomUUID().toString(),
    val value: Double,
    val description: String,
    val day: Int,
    val month: Int,
    val year: Int,
    val category: String
)