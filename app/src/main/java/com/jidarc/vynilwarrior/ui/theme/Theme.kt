package com.jidarc.vynilwarrior.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Vynil Warrior is dark themed only.

private val VynilWarriorDarkColorPalette = darkColors(
    primary = Green500,
    surface = DarkBlue900,
    onSurface = Color.White,
    background = DarkBlue900,
    onBackground = Color.White
)

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