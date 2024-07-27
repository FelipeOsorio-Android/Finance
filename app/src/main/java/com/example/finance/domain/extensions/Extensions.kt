package com.example.finance.domain.extensions

import com.example.finance.domain.entities.EntityUserFinance
import com.example.finance.domain.model.ModelUserFinance

fun EntityUserFinance.toModelUserFinance() = ModelUserFinance(
    value = value,
    description = description,
    date = date,
    category = category
)

fun ModelUserFinance.toEntityUserFinance() = EntityUserFinance(
    value = value,
    description = description,
    date = date,
    category = category
)