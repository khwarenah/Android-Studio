package com.atom.myapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atom.myapp.OnBoardViews.MainOnBoarding
import com.atom.myapp.ui.theme.MyAppTheme
import com.atom.myapp.Views.HomeView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val sharedPref = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val isBoardingCompleted = sharedPref.getBoolean("is_boarding_completed", false)

        setContent {
            MyAppTheme {
                var showOnBoarding by remember { mutableStateOf(!isBoardingCompleted) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (showOnBoarding) {
                        MainOnBoarding(
                            onFinish = {
                                sharedPref.edit().putBoolean("is_boarding_completed", true).apply()
                                showOnBoarding = false
                            }
                        )
                    } else {
                        HomeView(
                            onReset = {
                                sharedPref.edit().putBoolean("is_boarding_completed", false).apply()
                                showOnBoarding = true
                            }
                        )
                    }
                }
            }
        }
    }
}