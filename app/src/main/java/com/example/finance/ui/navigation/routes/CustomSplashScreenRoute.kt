package com.example.finance.ui.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.finance.ui.screens.CustomSplashScreen
import kotlinx.serialization.Serializable

@Serializable
object CustomSplashScreenRoute

fun NavGraphBuilder.customSplashScreen(onFinishAnimation: () -> Unit) {
    composable<CustomSplashScreenRoute> {
        CustomSplashScreen(onFinishAnimation = onFinishAnimation)
    }
}