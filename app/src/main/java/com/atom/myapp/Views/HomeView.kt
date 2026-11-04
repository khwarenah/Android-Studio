package com.atom.myapp.Views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atom.myapp.R

@Composable
fun HomeView(onReset: () -> Unit) {
    val context = LocalContext.current
    val prefs = context.getSharedPreferences("MarcadorPrefs", Context.MODE_PRIVATE)


    val nombre1 = prefs.getString("nombre_eq1", "Local") ?: "Local"
    val nombre2 = prefs.getString("nombre_eq2", "Visitante") ?: "Visitante"


    var puntos1 by remember { mutableIntStateOf(prefs.getInt("puntos_eq1", 0)) }
    var puntos2 by remember { mutableIntStateOf(prefs.getInt("puntos_eq2", 0)) }


    LaunchedEffect(puntos1, puntos2) {
        prefs.edit()
            .putInt("puntos_eq1", puntos1)
            .putInt("puntos_eq2", puntos2)
            .apply()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxSize()) {


            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF1E88E5))
                    .clickable { puntos1++ }
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.castersursus),
                    contentDescription = "Logo Equipo 1",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = nombre1,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = puntos1.toString(),
                    color = Color.White,
                    fontSize = 90.sp,
                    fontWeight = FontWeight.Bold
                )

                OutlinedButton(
                    onClick = { if (puntos1 > 0) puntos1-- },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text("-1")
                }
            }


            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFE53935))
                    .clickable { puntos2++ }
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.castersursus),
                    contentDescription = "Logo Equipo 2",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = nombre2,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = puntos2.toString(),
                    color = Color.White,
                    fontSize = 90.sp,
                    fontWeight = FontWeight.Bold
                )

                OutlinedButton(
                    onClick = { if (puntos2 > 0) puntos2-- },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text("-1")
                }
            }
        }


        Button(
            onClick = { onReset() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Text("Volver al OnBoarding")
        }
    }
}