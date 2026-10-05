package com.atom.myapp.Model

data class CalcularState (
    val precio :String="",
    val descuento : String="",
    val precioDescuento: Double=0.0,
    val TotalDescuento: Double=0.0,
    val showAlert: Boolean=false

)