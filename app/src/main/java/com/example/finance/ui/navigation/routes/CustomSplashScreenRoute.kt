package com.example.finance.ui.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.screens.CustomSplashScreen

fun NavGraphBuilder.customSplashScreen(onFinishAnimation: () -> Unit) {
    composable(route = Screens.CustomSplashScreenRoute.route) {
        CustomSplashScreen(onFinishAnimation = onFinishAnimation)
    }
}