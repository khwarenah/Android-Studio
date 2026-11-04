package com.atom.myapp.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atom.myapp.R

@Composable
fun HomeView(onReset: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Inicio")

        Spacer(modifier = Modifier.padding(20.dp))


        Image(
            painter = painterResource(id = R.drawable.castersursus),
            contentDescription = "Imagen 1",
            modifier = Modifier.size(350.dp)

        )





        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = { onReset() }) {
            Text("Volver al OnBoarding")
        }
    }
}