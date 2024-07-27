package com.example.finance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.finance.ui.navigation.navhost.FinanceNavHost
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.theme.FinanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            FinanceTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route
                val context = application.applicationContext

                val bottomNavRouteList = listOf(
                    Screens.HomeScreenRoute.route,
                    Screens.TransactionScreenRoute.route
                )

                val selectedIndex = remember {
                    mutableIntStateOf(0)
                }

                val showBottomNavigation by remember(currentRoute) {
                   derivedStateOf {
                       currentRoute == Screens.HomeScreenRoute.route ||
                               currentRoute == Screens.TransactionScreenRoute.route
                   }
                }

                FinanceApp(
                    selectedIndex = selectedIndex.intValue,
                    currentRoute = currentRoute,
                    bottomNavRouteList = bottomNavRouteList,
                    showBottomNavigation = showBottomNavigation,
                    onOptionSelected = { index ->
                        selectedIndex.intValue = index

                        navController.navigate(
                            route = bottomNavRouteList[index],
                            navOptions = navOptions {
                                popUpTo(Screens.HomeScreenRoute.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }

                        )
                    },
                    onNavigateForm = {
                        navController.navigate(Screens.FormScreenRoute.route)
                    },
                    onNavigateHome = {
                        navController.navigate(Screens.HomeScreenRoute.route)
                    }
                ) {
                    FinanceNavHost(context = context, navController = navController)
                }
            }
        }
    }
}