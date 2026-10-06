package com.atom.myapp.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.contentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.atom.myapp.Components.Alert
import com.atom.myapp.Components.MainButton
import com.atom.myapp.Components.MainTextField
import com.atom.myapp.Components.TwoCards
import com.atom.myapp.Components.spacer
import com.atom.myapp.ViewModel.CalcularViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: CalcularViewModel)
{
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("App Descuentos",
                        color = Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ){
        ContentHomeView( it, viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalcularViewModel){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = viewModel.state

        TwoCards(
            title = "Total",
            number1 = state.TotalDescuento,
            title2 = "Descuento",
            number2 = state.precioDescuento
        )

        MainTextField(value = state.precio, onValueChange = {viewModel.onValue(it, "precio")}, label = "precio")
        spacer()
        MainTextField(value = state.descuento, onValueChange = {viewModel.onValue(it, "descuento")}, label = "descuento")
        Spacer(10.dp)
        MainButton(text = "Generar descuento") {
            viewModel.calcula()
        }
        spacer()
        MainButton(text = "Limpiar") {
            viewModel.limpiar()
        }
        if(state.showAlert){
            Alert(
                title = "alerta",
                message = "Escribe precio y descuento",
                confirmText = "Aceptar",
                onConfirmClick = {viewModel.cancelAlert()}
            ) {

            }

        }
    }
}