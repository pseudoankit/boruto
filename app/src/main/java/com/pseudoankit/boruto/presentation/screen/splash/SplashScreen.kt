package com.pseudoankit.boruto.presentation.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.pseudoankit.boruto.R
import com.pseudoankit.boruto.presentation.ui.theme.Purple500
import com.pseudoankit.boruto.presentation.ui.theme.Purple700

@Composable
fun SplashScreen(navController: NavController) {
    val rotationAngle = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        rotationAngle.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 1000, delayMillis = 200)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Purple500, Purple700))),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = "splash",
            modifier = Modifier.rotate(rotationAngle.value)
        )
    }
}