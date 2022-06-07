package com.jidarc.vynilwarrior.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

val Green500 = Color(0xFF1EB980)
val DarkBlue900 = Color(0xFF26282F)

val Purple200 = Color(0xFFBB86FC)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val SplashScreenDarkColors = darkColors(
    surface = Color.LightGray,
    onSurface = Color.Black
)

val VynilThemeDarkColors = darkColors(
    // Vynil Warrior theme is dark-only
    background = Color(0XFF121212),
    surface = Color(0XFF121212),
    error = Color(0xFFCF6679),
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)