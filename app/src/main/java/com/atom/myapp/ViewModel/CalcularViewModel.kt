package com.atom.myapp.ViewModel


import com.atom.myapp.Model.CalcularState
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class CalcularViewModel : ViewModel() {

    var state by mutableStateOf(CalcularState())
        private set

    fun onValue(value: String, text: String) {
        when (text) {
            "precio" -> state = state.copy(precio = value)
            "descuento" -> state = state.copy(descuento = value)
        }
    }

    fun calcula() {
        val precio = state.precio
        val descuento = state.descuento

        val precioNum = precio.toDoubleOrNull()
        val descuentoNum = descuento.toDoubleOrNull()

        if (precioNum != null && descuentoNum != null) {
            state = state.copy(
                precioDescuento = calcularPrecio(precioNum, descuentoNum),
                totalDescuento = calcularDescuento(precioNum, descuentoNum)
            )
        } else {

            state = state.copy(
                showAlert = true
            )
        }
    }
    private fun calcularDescuento(precio: Double, descuento: Double): Double{
        val res: Double = precio*(1-descuento/100)
        return kotlin.math.round( res*100)/100.00
    }
    private fun calcularPrecio(precio: Double, descuento: Double): Double{
        val res: Double=precio-calcularDescuento(precio,descuento)
        return kotlin.math.round(res*100)/100
    }

    fun limpiar(){
        state = state.copy(
            precio = "",
            descuento = "",
            precioDescuento = 0.0,
            TotalDescuento = 0.0
        )
    }

    fun cancelAlert(){
        state = state.copy(
            showAlert = false
        )
    }

}