package com.atom.myapp.OnBoardViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ButtonFinish(currentPage: Int, onFinish: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        if (currentPage == 1) {
            OutlinedButton(
                onClick = { onFinish() },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Black.copy(alpha = 0.4f)
                )
            ) {
                Text(
                    text = "Comenzar Partido",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}