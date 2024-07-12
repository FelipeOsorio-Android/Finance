package com.example.finance.ui.components

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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finance.R
import com.example.finance.ui.theme.FinanceTheme
import com.example.finance.ui.theme.LimeGreen
import com.example.finance.ui.theme.LimeGreen30

sealed class IconBottomNav(@DrawableRes val icon: Int) {

    data object Home : IconBottomNav(R.drawable.ic_home)
    data object Transaction : IconBottomNav(R.drawable.ic_swap)

}

@Composable
fun CustomTabNavigation(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    bottomNavRouteList: List<Any> = emptyList(),
    onOptionSelected: (Int) -> Unit = {}
) {
    val iconList = listOf(
        IconBottomNav.Home,
        IconBottomNav.Transaction
    )

    TabRow(
        selectedTabIndex = selectedIndex,
        modifier
            .shadow(
                elevation = 10.dp,
                shape = CircleShape,
            )
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
        bottomNavRouteList.forEachIndexed { index, _ ->
            Tab(
                selected = selectedIndex == index,
                onClick = { onOptionSelected(index) },
                icon = {
                    when (selectedIndex == index) {
                        true -> {
                            Box(
                                Modifier
                                    .clip(shape = CircleShape)
                                    .background(color = LimeGreen30)
                                    .padding(10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = iconList[index].icon),
                                    contentDescription = null,
                                    Modifier.size(30.dp),
                                    tint = LimeGreen
                                )
                            }
                        }

                        false -> {
                            Icon(
                                painter = painterResource(id = iconList[index].icon),
                                contentDescription = null,
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