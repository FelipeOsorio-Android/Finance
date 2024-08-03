package com.example.finance.ui.navigation.routes

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.finance.domain.repository.RepositoryUserFinance
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.screens.form.FormScreen
import com.example.finance.ui.screens.form.FormViewModel

internal const val argsName = "FinanceId"

fun NavGraphBuilder.formScreen(context: Context) {
    composable(
        route = "${Screens.FormScreenRoute.route}?$argsName={$argsName}",
        arguments = listOf(navArgument(name = argsName) { nullable = true })
    ) {
        val viewModel = viewModel<FormViewModel>(factory = viewModelFactory {
            initializer {
                FormViewModel(
                    financeRepository = RepositoryUserFinance(context),
                    savedStateHandle = createSavedStateHandle()
                )
            }
        })
        val uiState by viewModel.uiState.collectAsState()

        FormScreen(uiState = uiState)
    }
}