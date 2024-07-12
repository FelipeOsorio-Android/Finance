package com.example.finance.ui.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.screens.HomeScreen

fun NavGraphBuilder.homeScreen() {
    composable(route = Screens.HomeScreenRoute.route) {
        HomeScreen()
    }
}