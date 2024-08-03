package com.example.finance.ui.screens.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finance.R
import com.example.finance.ui.screens.form.components.CustomBottomSheet
import com.example.finance.ui.screens.form.components.CustomDropDownMenu
import com.example.finance.ui.screens.form.components.DialogDatePicker
import com.example.finance.ui.theme.FinanceTheme
import com.example.finance.ui.theme.LimeGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    modifier: Modifier = Modifier,
    uiState: FormState = FormState()
) {

    val datePickerState = rememberDatePickerState()
    val sheetState = rememberModalBottomSheetState()
    val focusManager = LocalFocusManager.current

    val optionSelected = uiState.optionSelected
    val dropDownExpanded = uiState.dropDownExpanded
    val optionListDropDown = uiState.optionListDropDown
    val onDropDownExpanded = uiState.onDropDownExpanded
    val onDismissDropDown = uiState.onDismissDropDown
    val onOptionSelected = uiState.onOptionSelected

    val valueFieldMoney = uiState.valueFieldMoney
    val isErrorFieldMoney = uiState.isErrorFieldMoney
    val onValueChangeFieldMoney = uiState.onValueChangeFieldMoney
    val onFormatterFieldMoney = uiState.onFormatterFieldMoney

    val valueFieldDescription = uiState.valueFieldDescription
    val onValueChangeFieldDescription = uiState.onValueChangeFieldDescription

    val valueFieldDate = uiState.valueFieldDate
    val showDatePicker = uiState.showDatePicker
    val onShowDatePicker = uiState.onShowDatePicker
    val onDateSelected = uiState.onDateSelected
    val onDismissDatePicker = uiState.onDismissDatePicker

    val valueFieldCategory = uiState.valueFieldCategory
    val financialList = uiState.financialList
    val showBottomSheet = uiState.showBottomSheet
    val onShowBottomSheet = uiState.onShowBottomSheet
    val onSelectCategory = uiState.onSelectCategory
    val onDismissBottomSheet = uiState.onDismissBottomSheet

    val isEnable by remember(valueFieldMoney) {
        derivedStateOf { valueFieldMoney.isNotEmpty() && !isErrorFieldMoney }
    }

    Column(
        modifier
            .fillMaxSize()
    ) {
        CustomDropDownMenu(
            optionSelected = optionSelected,
            dropDownExpanded = dropDownExpanded,
            optionListDropDown = optionListDropDown,
            onDropDownExpanded = onDropDownExpanded,
            onDismissRequest = onDismissDropDown,
            onOptionSelected = onOptionSelected
        )

        OutlinedTextField(
            value = valueFieldMoney,
            onValueChange = onValueChangeFieldMoney,
            enabled = optionSelected.isNotEmpty(),
            label = {
                Text(text = "Valor")
            },
            placeholder = {
                Text(text = "Insira um valor")
            },
            prefix = {
                Text(text = "R$")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = if (isErrorFieldMoney) ImeAction.Done else ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onDone = null,
                onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                    onFormatterFieldMoney(valueFieldMoney)
                }
            ),
            trailingIcon = {
                if (isErrorFieldMoney) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_error_field),
                        contentDescription = null
                    )
                }
            },
            isError = isErrorFieldMoney
        )
        
        OutlinedTextField(
            value = valueFieldDescription,
            onValueChange = onValueChangeFieldDescription,
            label = {
                Text(text = "Descrição")
            },
            placeholder = {
                Text(text = "Insira uma descrição")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus(true)
                }
            )
        )

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = valueFieldDate,
                onValueChange = {},
                enabled = false,
                colors = OutlinedTextFieldDefaults.colors(
                    disabledContainerColor = Color.Transparent,
                    disabledTextColor = Color.Black,
                    disabledBorderColor = Color.Black
                )
            )
            DialogDatePicker(
                state = datePickerState,
                showDatePicker = showDatePicker,
                onDataSelected = onDateSelected,
                onDismissRequest = onDismissDatePicker
            )
            IconButton(
                onClick = onShowDatePicker,
                enabled = isEnable,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = LimeGreen,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = null
                )
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = valueFieldCategory,
                onValueChange = {},
                enabled = false,
                colors = OutlinedTextFieldDefaults.colors(
                    disabledContainerColor = Color.Transparent,
                    disabledTextColor = Color.Black,
                    disabledBorderColor = Color.Black
                )
            )
            CustomBottomSheet(
                Modifier
                    .fillMaxHeight(0.5F),
                sheetState = sheetState,
                showBottomSheet = showBottomSheet,
                onDismissRequest = onDismissBottomSheet
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(financialList) {
                        ListItem(
                            headlineContent = {
                                Text(text = it.label)
                            },
                            Modifier
                                .clickable { onSelectCategory(it.label) },
                            leadingContent = {
                                Icon(
                                    painter = painterResource(id = it.icon),
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            }
            IconButton(
                onClick = onShowBottomSheet,
                enabled = isEnable,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = LimeGreen,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = null
                )
            }
        }
        
        Button(
            onClick = uiState.saveUserFinance,
            enabled = isEnable && valueFieldDate.isNotEmpty() && valueFieldCategory.isNotEmpty()
        ) {
            Text(text = "Salvar")
        }
    }
}


@Preview
@Composable
private fun FormScreenPreview() {
    FinanceTheme {
        FormScreen()
    }
}