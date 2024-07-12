package com.example.finance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.finance.ui.components.CustomTabNavigation
import com.example.finance.ui.theme.FinanceTheme

@Composable
fun FinanceApp(
    modifier: Modifier = Modifier,
    showBottomNavigation: Boolean = false,
    selectedIndex: Int = 0,
    bottomNavRouteList: List<Any> = emptyList(),
    onOptionSelected: (Int) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            if (showBottomNavigation) {
                CustomTabNavigation(
                    selectedIndex = selectedIndex,
                    bottomNavRouteList = bottomNavRouteList,
                    onOptionSelected = onOptionSelected
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }
    }
}


@Preview
@Composable
private fun FinanceAppPreview() {
    FinanceTheme {
        FinanceApp()
    }
}