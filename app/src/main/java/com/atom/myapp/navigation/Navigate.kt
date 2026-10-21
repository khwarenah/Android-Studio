package com.atom.myapp.navigation

import com.atom.myapp.UiApp.RegistroScreen
import com.atom.myapp.UiApp.LoginScreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atom.myapp.UiApp.InicioScreen


@Composable
fun Navigate() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Login"
    ) {
        composable("Login") {
            LoginScreen(navController)
        }
        composable("Registro") {
            RegistroScreen(navController)
        }
        composable("Inicio") {
            InicioScreen(navController)
        }
    }
}