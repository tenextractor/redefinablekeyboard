package com.tenextractor.redefinablekeyboard.feature_config.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onNavToSelectLayouts = { navController.navigate("select_layouts") }
            )
        }
        composable("select_layouts") {
            SelectLayoutScreen()
        }
    }
}