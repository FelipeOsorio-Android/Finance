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
import com.example.finance.ui.screens.form.FormScreen
import com.example.finance.ui.screens.form.FormViewModel

fun NavGraphBuilder.formScreen(context: Context) {
    composable(route = Screens.FormScreenRoute.route) {
        val viewModel = viewModel<FormViewModel>(factory = viewModelFactory {
            initializer {
                FormViewModel(
                    financeRepository = RepositoryUserFinance(context)
                )
            }
        })
        val uiState by viewModel.uiState.collectAsState()

        FormScreen(uiState = uiState)
    }
}