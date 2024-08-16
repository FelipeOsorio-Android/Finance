package com.example.finance.domain.extensions

import com.example.finance.domain.entities.EntityUserFinance
import com.example.finance.domain.model.ModelUserFinance
import java.text.NumberFormat
import java.util.Locale

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

fun Double.toCurrency(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this)

    return format.replace("R$", "R$ ")
}