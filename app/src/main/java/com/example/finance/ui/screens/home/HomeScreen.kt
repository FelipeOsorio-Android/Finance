package com.example.finance.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finance.ui.theme.FinanceTheme
import com.example.finance.ui.theme.WhiteSmoke

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToForm: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = WhiteSmoke)
    ) {

    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    FinanceTheme {
        HomeScreen()
    }
}