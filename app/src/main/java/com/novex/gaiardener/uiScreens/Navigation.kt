package com.novex.gaiardener.uiScreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.novex.gaiardener.uiScreens.PlantSelectionScreen
import com.novex.gaiardener.uiScreens.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "homeScreen") {
        composable("homeScreen") { HomeScreen(navController) }
        composable("plantSelectionScreen") { PlantSelectionScreen(navController) }
    }
}
