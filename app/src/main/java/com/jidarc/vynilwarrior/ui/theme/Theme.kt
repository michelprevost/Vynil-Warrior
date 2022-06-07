package com.jidarc.vynilwarrior.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SplashScreenTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = SplashScreenDarkColors,
        typography = SplashScreenTypography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun VynilWarriorTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = VynilThemeDarkColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}