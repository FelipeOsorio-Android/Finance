package com.example.finance.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finance.domain.repository.RepositoryUserFinance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val financeRepository: RepositoryUserFinance
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            financeRepository.list.collect {
                _uiState.update { currentState ->
                    currentState.copy(
                        list = it
                    )
                }
            }
        }
    }
}