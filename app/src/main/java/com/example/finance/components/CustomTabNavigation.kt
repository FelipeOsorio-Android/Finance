package com.example.finance.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finance.R
import com.example.finance.ui.theme.FinanceTheme
import com.example.finance.ui.theme.LimeGreen
import com.example.finance.ui.theme.LimeGreen30

sealed class OptionsRoute(
    val label: String,
    @DrawableRes val icon: Int
) {
    data object Home : OptionsRoute(
        "Home",
        R.drawable.ic_home_filled,
    )

    data object Transactions : OptionsRoute(
        "Transactions",
        R.drawable.ic_swap_filled,
    )
}


@Composable
fun CustomTabNavigation(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    options: List<OptionsRoute> = listOf(OptionsRoute.Home, OptionsRoute.Transactions),
    onOptionSelected: (Int) -> Unit = {}
) {
    TabRow(
        selectedTabIndex = selectedIndex,
        modifier
            .clip(shape = CircleShape)
            .fillMaxWidth(0.5F),
        containerColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex]),
                color = Color.Transparent
            )
            TabRowDefaults.PrimaryIndicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex]),
                color = Color.Transparent
            )
        },
        divider = {
            HorizontalDivider(
                color = Color.Transparent
            )
        }
    ) {
        options.forEachIndexed { index, optionsRoute ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onOptionSelected(index) },
                icon = {
                    when (index == selectedIndex) {
                        true -> {
                            Box(
                                Modifier
                                    .clip(shape = CircleShape)
                                    .background(color = LimeGreen30)
                                    .padding(10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = optionsRoute.icon),
                                    contentDescription = optionsRoute.label,
                                    Modifier.size(30.dp),
                                    tint = LimeGreen
                                )
                            }
                        }

                        false -> {
                            Icon(
                                painter = painterResource(id = optionsRoute.icon),
                                contentDescription = optionsRoute.label,
                                Modifier.size(30.dp),
                                tint = Color.Black
                            )
                        }
                    }
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTabNavigationPreview() {
    FinanceTheme {
        CustomTabNavigation()
    }
}