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
            image = R.raw.g1,
            titulo = "Equipo Local",
            descripcion = "",
            teamColor = 0xFF408A71
        )
    )

    items.add(
        PageData(
            image = R.raw.g1,
            titulo = "Equipo Visitante",
            descripcion = "",
            teamColor = 0xFF285A48

        )
    )


    OnBoardingPager(
        item = items,
        onFinish = onFinish
    )
}