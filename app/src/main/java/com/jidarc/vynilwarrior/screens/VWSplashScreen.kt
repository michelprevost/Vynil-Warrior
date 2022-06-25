package com.jidarc.vynilwarrior.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jidarc.vynilwarrior.R
import com.jidarc.vynilwarrior.navigation.VWScreens
import com.jidarc.vynilwarrior.ui.theme.VynilWarriorTheme
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavController = NavController(LocalContext.current)) {
    VynilWarriorTheme() {

        val scale = remember {
            Animatable(0f)
        }

        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.9f,
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = {
                        OvershootInterpolator(8f).getInterpolation(it)
                    })
            )
            delay(2500L)
            navController.navigate(route = VWScreens.Home.name)
        }

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SplashScreenAnimatedText(modifier = Modifier.scale(scale.value))
                Spacer(modifier = Modifier.height(50.dp))
                RotatingVinyl()
            }
        }
    }
}

@Composable
fun SplashScreenAnimatedText(modifier: Modifier = Modifier) {
    // TODO; Animate this text
    Text(
        text = "Vynil Warrior",
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
fun RotatingVinyl(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1800, easing = LinearEasing)
        )
    )
    Image(
        painter = painterResource(id = R.drawable.ic_vinyl_record),
        contentDescription = "Vinyl record",
        modifier = modifier
            .size(300.dp)
            .rotate(angle)
    )
}