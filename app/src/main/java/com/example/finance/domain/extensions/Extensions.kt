package com.example.finance.domain.extensions

import com.example.finance.domain.entities.EntityUserFinance
import com.example.finance.domain.model.ModelUserFinance

fun EntityUserFinance.toModelUserFinance() = ModelUserFinance(
    id = id,
    type = type,
    value = value,
    description = description,
    date = date,
    category = category
)

fun ModelUserFinance.toEntityUserFinance() = EntityUserFinance(
    id = id,
    type = type,
    value = value,
    description = description,
    date = date,
    category = category
)