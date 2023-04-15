package com.example.gocab.screen.form_ojek_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gocab.R
import com.example.gocab.screen.common.BasicFormField
import com.example.gocab.screen.common.GedungGedungHeader
import com.example.gocab.screen.common.OrderButton

@Composable
fun FormOjekScreen(
    navController : NavHostController,
    viewModel: FormOjekViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsState().value
    FormOjekScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent,
        navController = navController
    )
}

@Composable
private fun FormOjekScreen(
    uiState: FormOjekUiState,
    onEvent : (FormOjekEvent) -> Unit,
    navController : NavHostController
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        GedungGedungHeader(
            onBackPressed = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.
                padding(
                    end = 24.dp,
                    start = 24.dp,
                    top = 24.dp
                )
        ) {
            BasicFormField(
                value = uiState.namaPelanggan,
                onValueChange = {
                    onEvent(FormOjekEvent.ChangeNamaPelanggan(it))
                },
                placeholder = "Nama Pelanggan",
                modifier = Modifier.fillMaxWidth()
            )

            BasicFormField(
                value = uiState.alamatPenjemputan,
                onValueChange = {
                    onEvent(FormOjekEvent.ChangeAlamatPenjemputan(it))
                },
                placeholder = "Alamat Penjemputan",
                modifier = Modifier.fillMaxWidth()
            )

            BasicFormField(
                value = uiState.tujuan,
                onValueChange = {
                    onEvent(FormOjekEvent.ChangeTujuan(it))
                },
                placeholder = "Alamat Tujuan",
                modifier = Modifier.fillMaxWidth()
            )

            BasicFormField(
                value = uiState.noWhatsapp,
                onValueChange = {
                    onEvent(FormOjekEvent.ChangeNoWhatsapp(it))
                },
                placeholder = stringResource(
                    id = R.string.placeholder_no_whatsapp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        OrderButton(
            onClick = {
                onEvent(FormOjekEvent.ClickOrder)
            },
            modifier = Modifier
                .padding(
                    horizontal = 24.dp,
                    vertical = 36.dp
                )
                .fillMaxWidth(),
        )
    }
}