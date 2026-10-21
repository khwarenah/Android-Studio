package com.atom.myapp.OnBoardViews

import android.media.Image
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieConstants


@Composable
fun LoaderData(modifier: Modifier, image: Int){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(image))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )


}