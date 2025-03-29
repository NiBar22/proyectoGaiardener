package com.novex.gaiardener.uiScreens

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.novex.gaiardener.ui.theme.GaiardenerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = 0xFF7BA05B.toInt()  // Color verde de fondo
        WindowCompat.setDecorFitsSystemWindows(window, false) // Extiende el contenido detrás de la barra
        setContent {
            val navController = rememberNavController()
            NavGraph(navController)
        }
    }
}
