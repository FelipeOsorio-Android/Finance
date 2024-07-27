package com.example.finance.ui.screens.home

import com.example.finance.domain.entities.EntityUserFinance

data class HomeState(
    val list: List<EntityUserFinance> = emptyList(),
)