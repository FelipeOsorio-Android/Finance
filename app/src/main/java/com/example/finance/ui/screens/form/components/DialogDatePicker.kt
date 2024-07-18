package com.example.finance.ui.screens.form.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.finance.ui.theme.FinanceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogDatePicker(
    modifier: Modifier = Modifier,
    state: DatePickerState = rememberDatePickerState(),
    onDataSelected: (Long?) -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = { 
            TextButton(onClick = { onDataSelected(state.selectedDateMillis) }) {
                Text(text = "Confirmar")
            }
        }
    ) {
        DatePicker(state = state)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DialogDatePickerPreview() {
    FinanceTheme {
        DialogDatePicker()
    }
}