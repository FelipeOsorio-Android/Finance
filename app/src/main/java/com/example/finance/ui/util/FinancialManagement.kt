package com.example.finance.ui.util

import androidx.annotation.DrawableRes
import com.example.finance.R

sealed class FinancialManagement(
    val type: String,
    val label: String,
    @DrawableRes val icon: Int
) {
    data object Trips : FinancialManagement(
        type = "Despesa",
        label = "Viagens",
        icon = R.drawable.ic_trip
    )

    data object Repair : FinancialManagement(
        type = "Despesa",
        label = "Manutenção",
        icon = R.drawable.ic_tools
    )

    data object Food : FinancialManagement(
        type = "Despesa",
        label = "Alimentação",
        icon = R.drawable.ic_fast_food
    )

    data object House : FinancialManagement(
        type = "Despesa",
        label = "Casa",
        icon = R.drawable.ic_house
    )

    data object Car : FinancialManagement(
        type = "Despesa",
        label = "Carro",
        icon = R.drawable.ic_car
    )

    data object Education : FinancialManagement(
        type = "Despesa",
        label = "Educação",
        icon = R.drawable.ic_book
    )

    data object Health : FinancialManagement(
        type = "Despesa",
        label = "Saúde",
        icon = R.drawable.ic_health
    )

    data object Salary : FinancialManagement(
        type = "Receita",
        label = "Salário",
        icon = R.drawable.ic_income_money
    )

    data object Investments : FinancialManagement(
        type = "Receita",
        label = "Investimentos",
        icon = R.drawable.ic_investiment
    )

    data object Bonus : FinancialManagement(
        type = "Receita",
        label = "Premiação",
        icon = R.drawable.ic_bonus
    )


}