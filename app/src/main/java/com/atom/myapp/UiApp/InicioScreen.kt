package com.atom.myapp.UiApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.atom.myapp.Data.StoreUserMail

@Composable
fun InicioScreen(navController: NavController) {
    val context = LocalContext.current
    val dataStore = StoreUserMail(context)

    val userEmail = dataStore.getMail.collectAsState(initial = "")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Inicio de sesion exitoso", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Bienvenido:")
        Text(text = userEmail.value.toString(), fontSize = 20.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            navController.navigate("Login") {
                popUpTo("Inicio") { inclusive = true }
            }
        }) {
            Text(text = "Cerrar Sesion")
        }
    }
}