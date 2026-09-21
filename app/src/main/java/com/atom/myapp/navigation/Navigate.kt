package com.atom.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atom.myapp.UIapp.Detail
import com.atom.myapp.UIapp.Home

@Composable
fun Navigate() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(route = "Home") {
            Home(navController)
        }

        composable(route = "Detail") {
            Detail(navController)
        }
    }
}