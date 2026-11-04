package com.atom.myapp.OnBoardViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.atom.myapp.Data.PageData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.atom.myapp.R
import androidx.compose.foundation.pager.rememberPagerState

@OptIn  (ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(onFinish: () -> Unit) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            image = R.raw.redcar,
            titulo = "Equipo Local",
            descripcion = "Configura el equipo de casa",
            teamColor = 0xFF1E88E5
        )
    )

    items.add(
        PageData(
            image = R.raw.carwash,
            titulo = "Equipo Visitante",
            descripcion = "Configura al equipo rival",
            teamColor = 0xFFE53935
        )
    )


    OnBoardingPager(
        item = items,
        onFinish = onFinish
    )
}