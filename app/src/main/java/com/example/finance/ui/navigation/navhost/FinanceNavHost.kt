package com.example.finance.ui.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.finance.ui.navigation.routes.CustomSplashScreenRoute
import com.example.finance.ui.navigation.routes.HomeScreenRoute
import com.example.finance.ui.navigation.routes.TransactionScreenRoute
import com.example.finance.ui.navigation.routes.customSplashScreen
import com.example.finance.ui.navigation.routes.homeScreen
import com.example.finance.ui.navigation.routes.transactionScreen

@Composable
fun FinanceNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = CustomSplashScreenRoute) {
        customSplashScreen(
            onFinishAnimation = {
                navController.popBackStack()
                navController.navigate(HomeScreenRoute)
            }
        )
        homeScreen()
        transactionScreen()
    }
}

fun NavHostController.bottomNavigation(index: Int) {
    val route = when (index) {
        0 -> HomeScreenRoute
        1 -> TransactionScreenRoute
        else -> throw IllegalArgumentException("Invalid index")
    }

    navigate(route, navOptions = navOptions {
        popUpTo(HomeScreenRoute)
        launchSingleTop = true
        restoreState = true
    })
}