package com.atom.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atom.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Formulario(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Formulario(modifier: Modifier = Modifier) {
    var contadorIzquierda by remember { mutableStateOf(0) }
    var contadorDerecha by remember { mutableStateOf(0) }

    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(color = Color.Magenta, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contadorIzquierda.toString(),
                    fontSize = 45.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { contadorIzquierda++ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .width(110.dp)
                    .height(45.dp)
            ) {
                Text(text = "Sumar", fontSize = 16.sp, color = Color.Magenta)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { contadorIzquierda-- },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .width(110.dp)
                    .height(45.dp)
            ) {
                Text(text = "Restar", fontSize = 16.sp, color = Color.Magenta)
            }
        }

        Column(
            verticalArrangement =
                Arrangement.spacedBy(12.dp),
            horizontalAlignment=
                Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    contadorIzquierda = 0
                    contadorDerecha = 0
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Reiniciar",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(color = Color.Magenta, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contadorDerecha.toString(),
                    fontSize = 45.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { contadorDerecha++ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .width(110.dp)
                    .height(45.dp)
            ) {
                Text(text = "Sumar", fontSize = 16.sp, color = Color.Magenta)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { contadorDerecha-- },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .width(110.dp)
                    .height(45.dp)
            ) {
                Text(text = "Restar", fontSize = 16.sp, color = Color.Magenta)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FormularioPreview() {
    Formulario()
}