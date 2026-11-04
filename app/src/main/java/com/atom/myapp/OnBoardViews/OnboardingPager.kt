package com.atom.myapp.OnBoardViews

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atom.myapp.Data.PageData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPager(
    item: List<PageData>,
    modifier: Modifier = Modifier,
    onFinish: () -> Unit
) {

    val pagerState = rememberPagerState(pageCount = { item.size })

    var equipo1 by remember { mutableStateOf("") }
    var equipo2 by remember { mutableStateOf("") }

    val context = LocalContext.current
    val prefs = context.getSharedPreferences("MarcadorPrefs", Context.MODE_PRIVATE)

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(item[page].teamColor))
                        .padding(40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LoaderData(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth(),
                        item[page].image
                    )

                    Text(
                        text = item[page].titulo,
                        modifier = Modifier.padding(top = 30.dp),
                        color = Color.White,
                        style = MaterialTheme.typography.displayLarge,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )

                    Text(
                        text = item[page].descripcion,
                        color = Color.White,
                        modifier = Modifier.padding(top = 8.dp, bottom = 30.dp)
                    )


                    OutlinedTextField(
                        value = if (page == 0) equipo1 else equipo2,
                        onValueChange = { if (page == 0) equipo1 = it else equipo2 = it },
                        label = { Text("Nombre del equipo", color = Color.White) },
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )
                }
            }


            PageIndicator(item.size, pagerState.currentPage)
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        ) {

            ButtonFinish(currentPage = pagerState.currentPage) {

                val nom1 = equipo1.ifBlank { "Local" }
                val nom2 = equipo2.ifBlank { "Visitante" }

                prefs.edit()
                    .putString("nombre_eq1", nom1)
                    .putString("nombre_eq2", nom2)
                    .putInt("puntos_eq1", 0)
                    .putInt("puntos_eq2", 0)
                    .putBoolean("partido_en_curso", true)
                    .apply()

                onFinish()
            }
        }
    }
}