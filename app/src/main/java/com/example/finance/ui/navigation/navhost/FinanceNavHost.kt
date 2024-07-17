package com.example.finance.ui.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.finance.ui.navigation.routes.customSplashScreen
import com.example.finance.ui.navigation.routes.formScreen
import com.example.finance.ui.navigation.routes.homeScreen
import com.example.finance.ui.navigation.routes.transactionScreen

sealed class Screens(val route: String) {


    data object CustomSplashScreenRoute : Screens(route = "SplashScreen")


    data object HomeScreenRoute : Screens(route = "HomeScreen")


    data object TransactionScreenRoute : Screens(route = "TransactionScreen")

    data object FormScreenRoute : Screens(route = "FormScreen")
}

@Composable
fun FinanceNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Screens.CustomSplashScreenRoute.route) {
        customSplashScreen(
            onFinishAnimation = {
                navController.popBackStack()
                navController.navigate(Screens.HomeScreenRoute.route)
            }
        )
        homeScreen(
            onNavigateToForm = {
                navController.navigate(route = Screens.FormScreenRoute.route)
            }
        )
        transactionScreen()
        formScreen()
    }
}