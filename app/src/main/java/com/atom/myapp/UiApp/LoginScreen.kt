package com.atom.myapp.UiApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.atom.myapp.Data.StoreUserMail
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import com.atom.myapp.R

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val dataStore = StoreUserMail(context)

    val storedEmail = dataStore.getMail.collectAsState(initial = "")
    val storedPass = dataStore.getPass.collectAsState(initial = "")

    var emailInput by rememberSaveable { mutableStateOf("") }
    var passInput by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {


        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Imagen 1",
            modifier = Modifier.size(120.dp)
        )


        Text(text = "Iniciar Sesion")

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = emailInput,
            onValueChange = {
                emailInput = it
                errorMessage = ""
            },
            label = { Text(text = "Email") },
        )

        TextField(
            value = passInput,
            onValueChange =  {
                passInput = it
                errorMessage = ""
            },
            label = {Text("Contraseña")}
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = errorMessage, color = Color.Magenta)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (emailInput.isNotEmpty() && passInput.isNotEmpty() &&
                emailInput == storedEmail.value && passInput == storedPass.value) {
                navController.navigate("Inicio")
            }else {
                errorMessage = "Correo o contraseña mal ingresado"
            }
        }) {
            Text(text = "Ingresar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.navigate("Registro")
        }) {
            Text(text = "No cuento con una cuenta")
        }
    }
}