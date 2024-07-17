package com.example.finance.ui.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.screens.home.HomeScreen

fun NavGraphBuilder.homeScreen(onNavigateToForm: () -> Unit) {
    composable(route = Screens.HomeScreenRoute.route) {
        HomeScreen(onNavigateToForm = onNavigateToForm)
    }
}