package com.atom.myapp.modelView

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State


class ContadorViewModel: ViewModel(){
    private val _contador= mutableStateOf(value=0)
    val contador: State<Int> = _contador

    fun add(){
        _contador.value=_contador.value + 1



    }
 }