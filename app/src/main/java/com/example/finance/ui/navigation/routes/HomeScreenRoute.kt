package com.example.finance.ui.navigation.routes

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.finance.domain.repository.RepositoryUserFinance
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.screens.home.HomeScreen
import com.example.finance.ui.screens.home.HomeViewModel

fun NavGraphBuilder.homeScreen(
    context: Context
) {
    composable(route = Screens.HomeScreenRoute.route) {
        val viewModel = viewModel<HomeViewModel>(factory = viewModelFactory {
            initializer {
                HomeViewModel(
                    financeRepository = RepositoryUserFinance(context)
                )
            }
        })

        val uiState by viewModel.uiState.collectAsState()

        HomeScreen(
            uiState = uiState,
        )
    }
}