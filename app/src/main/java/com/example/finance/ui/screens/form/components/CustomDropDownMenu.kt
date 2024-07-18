package com.example.finance.ui.screens.form.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finance.R
import com.example.finance.ui.theme.FinanceTheme

@Composable
fun CustomDropDownMenu(
    modifier: Modifier = Modifier,
    optionSelected: String = "",
    expanded: Boolean = false,
    dropDownItemList: List<String> = emptyList(),
    onOptionSelected: (String) -> Unit = {},
    onDismissRequest: () -> Unit = {},
    showOptions: () -> Unit = {}
) {
    Box(
        modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Red)
            .wrapContentSize(align = Alignment.TopStart)
            .padding(4.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = optionSelected)
            IconButton(onClick = showOptions) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow_down), contentDescription = null)
            }
        }

        DropdownMenu(expanded = expanded, onDismissRequest = onDismissRequest, Modifier.fillMaxWidth()) {
            dropDownItemList.forEach { item ->
                DropdownMenuItem(text = { Text(text = item) }, onClick = {onOptionSelected(item)})
            }
        }
    }
}


@Preview
@Composable
private fun CustomDropDownMenuPreview() {
    FinanceTheme {
        CustomDropDownMenu()
    }
}