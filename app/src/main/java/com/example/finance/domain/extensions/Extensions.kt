package com.example.finance.domain.extensions

import com.example.finance.domain.entities.EntityUserFinance
import com.example.finance.domain.model.ModelUserFinance

fun EntityUserFinance.toModelUserFinance() = ModelUserFinance(
    id = id,
    value = value,
    description = description,
    day = day,
    month = month,
    year = year,
    category = category
)

fun ModelUserFinance.toEntityUserFinance() = EntityUserFinance(
    id = id,
    value = value,
    description = description,
    day = day,
    month = month,
    year = year,
    category = category
)