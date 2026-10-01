package com.atom.myapp.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TwoCards(title:String, number1:Double, number2:Double, title2:String) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        MainCard()

    }

}

@Composable
fun MainCard(title: String, number: Double, modifier: Modifier = Modifier){
    Card( modifier = modifier

    ){}
}