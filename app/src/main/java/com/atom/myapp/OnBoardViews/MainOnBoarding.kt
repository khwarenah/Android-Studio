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
fun MainOnBoarding(){
    val items= ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.welcome,
            titulo ="Entrada",
            descripcion = "Descripcion de la aplicacion en el momento de la entrada"
        )
    )

    items.add(
        PageData(
            R.raw.carwash,
            titulo="Medio",
            descripcion = "Descripcion de la aplicacion en el momento medio de la aplicacion"
        )
    )

    items.add(
        PageData(
            R.raw.redcar,
            titulo ="Entrada",
            descripcion = "Descripcion de la aplicacion en el momento de la entrada"
        )
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { items.size }
    )

    OnBoardingPager(
        item =items, pagerState = pagerState, modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )

}