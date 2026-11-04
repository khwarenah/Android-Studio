package com.atom.myapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.atom.myapp.OnBoardViews.MainOnBoarding
import com.atom.myapp.Views.HomeView
import com.atom.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val prefs = getSharedPreferences("MarcadorPrefs", Context.MODE_PRIVATE)
        val partidoEnCurso = prefs.getBoolean("partido_en_curso", false)

        setContent {
            MyAppTheme {

                var showScore by remember { mutableStateOf(partidoEnCurso) }

                Surface(modifier = Modifier.fillMaxSize()) {
                    if (!showScore) {

                        MainOnBoarding(
                            onFinish = {
                                showScore = true
                            }
                        )
                    } else {

                        HomeView(
                            onReset = {
                                prefs.edit().putBoolean("partido_en_curso", false).apply()
                                showScore = false
                            }
                        )
                    }
                }
            }
        }
    }
}