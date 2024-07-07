package com.example.finance.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finance.R
import com.example.finance.ui.theme.FinanceTheme

sealed class OptionsRoute(
    val label: String,
    @DrawableRes val activeContent: Int,
    @DrawableRes val inactiveContent: Int
) {
    data object Home : OptionsRoute(
        "Home",
        R.drawable.ic_home_filled,
        R.drawable.ic_home_outlined
    )
    data object Transactions : OptionsRoute(
        "Transactions",
        R.drawable.ic_swap_filled,
        R.drawable.ic_swap_outlined
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSegmentButton(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    options: List<OptionsRoute> = emptyList(),
    onOptionSelected: (Int) -> Unit = {}
) {
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, option ->
            SegmentedButton(
                selected = index == selectedIndex,
                onClick = { onOptionSelected(index) },
                border = BorderStroke(width = 0.dp, color = Color.Transparent),
                colors = SegmentedButtonDefaults.colors(
                    activeContentColor = Color.Black,
                    inactiveContentColor = Color(0xFFA9A9A9)
                ),
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                icon = {
                    SegmentedButtonDefaults.Icon(
                    active = index == selectedIndex,
                    activeContent = {
                        when (index) {
                            0 -> Icon(painter = painterResource(id = R.drawable.ic_home_filled), contentDescription = null)
                            1 -> Icon(painter = painterResource(id = R.drawable.ic_swap_filled), contentDescription = null)
                        }
                    },
                    inactiveContent = {
                        when (index) {
                            0 -> Icon(painter = painterResource(id = R.drawable.ic_home_outlined), contentDescription = null)
                            1 -> Icon(painter = painterResource(id = R.drawable.ic_swap_outlined), contentDescription = null)
                        }
                    }
                )}
            ) {
                Text(text = option.label)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomSegmentButtonPreview() {
    FinanceTheme {
        CustomSegmentButton()
    }
}