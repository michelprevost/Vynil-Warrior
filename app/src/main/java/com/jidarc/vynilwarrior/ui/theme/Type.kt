package com.jidarc.vynilwarrior.ui.theme

import android.window.SplashScreen
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jidarc.vynilwarrior.R

private val LobsterFontFamily = FontFamily(
    Font(R.font.lobster_regular),
    Font(R.font.lobster_regular, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val SplashScreenTypography = Typography(
    h2 = TextStyle(
        fontFamily = LobsterFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 50.sp
    )
)