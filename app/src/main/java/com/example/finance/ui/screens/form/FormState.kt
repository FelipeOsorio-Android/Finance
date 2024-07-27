package com.example.finance.ui.screens.form

import com.example.finance.ui.util.FinancialManagement

data class FormState(
    val optionSelected: String = "",
    val dropDownExpanded: Boolean = false,
    val optionListDropDown: List<String> = emptyList(),
    val valueFieldMoney: String = "",
    val isErrorFieldMoney: Boolean = false,
    val valueFieldDescription: String = "",
    val valueFieldDate: String = "",
    val showDatePicker: Boolean = false,
    val valueFieldCategory: String = "",
    val showBottomSheet: Boolean = false,
    val financialList: List<FinancialManagement> = emptyList(),
    val onShowBottomSheet: () -> Unit = {},
    val onDismissBottomSheet: () -> Unit = {},
    val onSelectCategory: (String) -> Unit = {},
    val onShowDatePicker: () -> Unit = {},
    val onDateSelected: (Long?) -> Unit = {},
    val onDismissDatePicker: () -> Unit = {},
    val onValueChangeFieldDescription: (String) -> Unit = {},
    val onValueChangeFieldMoney: (String) -> Unit = {},
    val onFormatterFieldMoney: (String) -> Unit = {},
    val onDropDownExpanded: () -> Unit = {},
    val onDismissDropDown: () -> Unit = {},
    val onOptionSelected: (String) -> Unit = {},
    val saveUserFinance: () -> Unit = {}
)