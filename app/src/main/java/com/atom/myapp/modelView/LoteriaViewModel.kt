package com.atom.myapp.modelView

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.State

class LoteriaViewModel: ViewModel(){
    private val _loteriaNumbers = mutableStateOf<List<Int>>(emptyList())
    val loteriaNumbers: State<List<Int>> = _loteriaNumbers

    fun generadorNumeros(){
        _loteriaNumbers.value = (1 .. 60).shuffled().take(n = 6).sorted()
    }

}