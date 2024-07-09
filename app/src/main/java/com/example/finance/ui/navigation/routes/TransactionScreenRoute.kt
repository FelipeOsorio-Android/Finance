package com.example.finance.ui.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.finance.ui.screens.TransactionScreen
import kotlinx.serialization.Serializable

@Serializable
object TransactionScreenRoute

fun NavGraphBuilder.transactionScreen() {
    composable<TransactionScreenRoute> {
        TransactionScreen()
    }
}