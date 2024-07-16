package com.example.finance.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.finance.R
import com.example.finance.ui.theme.FinanceTheme

@Composable
fun CustomSplashScreen(
    modifier: Modifier = Modifier,
    onFinishAnimation: () -> Unit = {}
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.coins_animation)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        restartOnPlay = false,
    )

    val finishAnimation by remember {
        derivedStateOf {
            progress == 1F
        }
    }

    if (finishAnimation) {
        LaunchedEffect(key1 = true) {
            onFinishAnimation()
        }
    }

    Column(
        modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition,
            contentScale = ContentScale.Crop
        )
    }
}


@Preview
@Composable
private fun CustomSplashScreenPreview() {
    FinanceTheme {
        CustomSplashScreen()
    }
}