package com.example.finance.ui.screens.transaction

import androidx.lifecycle.ViewModel
import com.example.finance.domain.repository.RepositoryUserFinance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class TransactionViewModel(private val repository: RepositoryUserFinance) : ViewModel() {

    private val _uiState = MutableStateFlow(TransactionState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                month = Clock.System.now().toLocalDateTime(timeZone = TimeZone.of("GMT")).month.name
            )
        }
    }

}