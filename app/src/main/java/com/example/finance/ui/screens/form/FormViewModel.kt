package com.example.finance.ui.screens.form

import android.icu.text.DateFormat
import android.icu.text.NumberFormat
import android.icu.util.TimeZone
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finance.domain.extensions.toEntityUserFinance
import com.example.finance.domain.model.ModelUserFinance
import com.example.finance.domain.repository.RepositoryUserFinance
import com.example.finance.ui.util.FinancialManagement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import java.util.Locale
import java.util.regex.Pattern

class FormViewModel(
    private val financeRepository: RepositoryUserFinance
) : ViewModel() {
    private val _uiState: MutableStateFlow<FormState> = MutableStateFlow(FormState())
    val uiState get() = _uiState.asStateFlow()

    private val financialList = listOf(
        FinancialManagement.Trips,
        FinancialManagement.Repair,
        FinancialManagement.Food,
        FinancialManagement.House,
        FinancialManagement.Car,
        FinancialManagement.Education,
        FinancialManagement.Health,
        FinancialManagement.Salary,
        FinancialManagement.Investments,
        FinancialManagement.Bonus
    )

    init {
        _uiState.update { currentState ->
            currentState.copy(
                optionListDropDown = listOf("Despesa", "Receita"),

                onDropDownExpanded = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            dropDownExpanded = !currentState.dropDownExpanded
                        )
                    }
                },
                onDismissDropDown = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            dropDownExpanded = false
                        )
                    }
                },
                onOptionSelected = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            optionSelected = it,
                            financialList = financialList.filter { item -> item.type == it },
                            dropDownExpanded = false
                        )
                    }
                },
                onValueChangeFieldMoney = {
                    val fieldValidation = Pattern.matches("[0-9]*", it) ||
                            Pattern.matches("^\\d{1,3}([.,]\\d{1,2})?$", it)

                    _uiState.update { currentState ->
                        currentState.copy(
                            valueFieldMoney = it,
                            isErrorFieldMoney = !fieldValidation
                        )
                    }
                },
                onFormatterFieldMoney = {
                    when {
                        it.contains('.') -> {
                            _uiState.update { currentState ->
                                currentState.copy(
                                    valueFieldMoney = it.replace('.', ',')
                                )
                            }
                        }

                        it.contains(',') -> {
                            _uiState.update { currentState ->
                                currentState.copy(
                                    valueFieldMoney = it
                                )
                            }
                        }

                        else -> {
                            _uiState.update { currentState ->
                                currentState.copy(
                                    valueFieldMoney = NumberFormat.getCurrencyInstance(
                                        Locale("pt", "br")
                                    )
                                        .format(it.toDouble()).removePrefix("R$").trim()
                                )
                            }
                        }
                    }

                },
                onValueChangeFieldDescription = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            valueFieldDescription = it
                        )
                    }
                },
                onShowDatePicker = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            showDatePicker = !currentState.showDatePicker
                        )
                    }
                },
                onDismissDatePicker = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            showDatePicker = false
                        )
                    }
                },
                onDateSelected = {
                    it?.let {
                        val date = Date(it)
                        val formatter = DateFormat.getDateInstance(DateFormat.DATE_FIELD).apply {
                            this.timeZone = TimeZone.getTimeZone("UTC")
                        }
                        val newDate = formatter.format(date)

                        _uiState.update { currentState ->
                            currentState.copy(
                                valueFieldDate = newDate,
                                showDatePicker = false
                            )
                        }
                    }
                },
                onShowBottomSheet = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            showBottomSheet = !currentState.showBottomSheet
                        )
                    }
                },
                onDismissBottomSheet = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            showBottomSheet = false
                        )
                    }
                },
                onSelectCategory = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            valueFieldCategory = it,
                            showBottomSheet = false
                        )
                    }
                },
                saveUserFinance = {
                    val finance = ModelUserFinance(
                        date = _uiState.value.valueFieldDate,
                        value = _uiState.value.valueFieldMoney.replace(",", ".").toDouble(),
                        description = _uiState.value.valueFieldDescription,
                        category = _uiState.value.valueFieldCategory
                    )
                    viewModelScope.launch {
                        financeRepository.saveUserFinance(finance.toEntityUserFinance())
                    }
                }
            )
        }
    }
}