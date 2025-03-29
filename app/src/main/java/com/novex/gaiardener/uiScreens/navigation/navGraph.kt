package com.novex.gaiardener.uiScreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "homeScreen"
    ) {
        composable("homeScreen") { HomeScreen(navController) }
        composable("plantSelectionScreen") { PlantSelectionScreen(navController) }

        // PlantDetailScreen con argumentos
        composable(
            "plant_detail/{plantName}/{scientificName}/{description}/{imageRes}",
            arguments = listOf(
                navArgument("plantName") { type = NavType.StringType },
                navArgument("scientificName") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("imageRes") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            PlantDetailScreen(
                navController,
                plantName = backStackEntry.arguments?.getString("plantName") ?: "",
                scientificName = backStackEntry.arguments?.getString("scientificName") ?: "",
                description = backStackEntry.arguments?.getString("description") ?: "",
                imageRes = backStackEntry.arguments?.getInt("imageRes") ?: 0
            )
        }
    }
}
