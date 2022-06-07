package com.jidarc.vynilwarrior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jidarc.vynilwarrior.navigation.VWNavigation
import com.jidarc.vynilwarrior.ui.theme.VynilWarriorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRoot()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeRoot() {
    VynilWarriorTheme {
        VWNavigation()
    }
}
