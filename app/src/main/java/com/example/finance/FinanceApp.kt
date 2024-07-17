package com.example.finance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finance.ui.components.CustomTabNavigation
import com.example.finance.ui.components.CustomTopAppBar
import com.example.finance.ui.navigation.navhost.Screens
import com.example.finance.ui.theme.FinanceTheme
import com.example.finance.ui.theme.LimeGreen

@Composable
fun FinanceApp(
    modifier: Modifier = Modifier,
    currentRoute: String? = null,
    showBottomNavigation: Boolean = false,
    selectedIndex: Int = 0,
    bottomNavRouteList: List<Any> = emptyList(),
    onOptionSelected: (Int) -> Unit = {},
    onNavigateForm: () -> Unit = {},
    onNavigateHome: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            when (currentRoute) {
                Screens.HomeScreenRoute.route, Screens.TransactionScreenRoute.route -> {
                    CustomTopAppBar(
                        title = "Finance",
                        navigationIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_coin),
                                contentDescription = null,
                                Modifier.size(40.dp)
                            )
                        },
                        actions = {
                            IconButton(
                                onClick = onNavigateForm,
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = LimeGreen,
                                    contentColor = Color.White
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                )
                            }
                        }
                    )
                }

                Screens.FormScreenRoute.route -> {
                    CustomTopAppBar(
                        title = currentRoute,
                        navigationIcon = {
                            IconButton(onClick = onNavigateHome) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow_left),
                                    contentDescription = null
                                )
                            }
                        }
                    )
                }
            }
        },
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