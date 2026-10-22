package com.atom.myapp.OnBoardViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    size: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.padding(top = 60.dp)
    ) {
        repeat(times = size) { index ->
            Indicator(isSelect = index == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelect: Boolean) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .height(5.dp)
            .width(5.dp)
            .clip(CircleShape)
            .background(color = if (isSelect) Color.Red else Color.Gray)
    ) { }
}
