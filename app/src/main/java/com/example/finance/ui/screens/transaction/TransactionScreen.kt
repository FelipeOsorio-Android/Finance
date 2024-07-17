package com.example.finance.ui.screens.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.finance.ui.theme.FinanceTheme

@Composable
fun TransactionScreen(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {

    }
}


@Preview
@Composable
private fun TransactionScreenPreview() {
    FinanceTheme {
        TransactionScreen()
    }
}