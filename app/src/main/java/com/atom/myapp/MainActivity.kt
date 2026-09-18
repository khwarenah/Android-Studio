package com.atom.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
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
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Contenido()
                    }
                }
            }
        }
    }
}

@Composable
fun Contenido() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonNormal()
        Espacio()
        BotonNomral2()
        Espacio()
        BotonTexto()
        Espacio()
        BotonOutLine()
        Espacio()
        BotonIcono()
        Espacio()
        BotonFlotante()
    }
}

@Composable
fun Espacio() {
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun BotonNormal() {
    Button(onClick = {}) {
        Text("Mi boton", fontSize = 10.sp)
    }
}

@Composable
fun BotonNomral2() {
    Button(onClick = {}) {
        Text("Mi boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonTexto() {
    TextButton(onClick = {}) {
        Text("Mi boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutLine() {
    OutlinedButton(
        onClick = {},
        border = BorderStroke(3.dp, Color.Green)
    ) {
        Text("Mi boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono() {
    IconButton(onClick = {}) {
        Icon(
            painter = painterResource(id = R.drawable.iconhome),
            contentDescription = "",
            modifier = Modifier.size(30.dp)


        )
    }
}

@Composable
fun BotonFlotante(){
    FloatingActionButton(onClick = {},
        containerColor = Color.Magenta,
        contentColor = Color.Green) {
        Icon(
            painter = painterResource(id = R.drawable.iconhome),
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
    }
}