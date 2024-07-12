package com.example.finance.ui.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.screens.TransactionScreen

fun NavGraphBuilder.transactionScreen() {
    composable(route = Screens.TransactionScreenRoute.route) {
        TransactionScreen()
    }
}