package com.example.gocab.screen.form_pengantaran_barang

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gocab.screen.common.BasicFormField
import com.example.gocab.screen.common.GedungGedungHeader
import com.example.gocab.screen.common.OrderButton

@Composable
fun FormPengantaranBarangScreen(
    viewModel : FormPengantaranBarangViewModel = hiltViewModel(),
    navController : NavHostController,
){
    FormPengantaranBarangScreen(
        uiState = viewModel.uiState.collectAsState().value,
        navController = navController,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun FormPengantaranBarangScreen(
    uiState : FormPengantaranBarangUiState,
    navController : NavHostController,
    onEvent : (FormPengantaranBarangEvent) -> Unit
){
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        GedungGedungHeader(onBackPressed = { navController.popBackStack() } )

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    start = 24.dp,
                    end = 24.dp
                )
        ) {
            BasicFormField(
                value = uiState.namaPengirim,
                onValueChange = {
                    onEvent(FormPengantaranBarangEvent.ChangeNamaPengirim(it))
                },
                placeholder = "Nama Pengirim",
                modifier = Modifier
                    .fillMaxWidth()
            )

            BasicFormField(
                value = uiState.alamatPengambilan,
                onValueChange = {
                    onEvent(FormPengantaranBarangEvent.ChangeAlamatPengambilan(it))
                },
                placeholder = "Alamat Pengambilan",
                modifier = Modifier
                    .fillMaxWidth()
            )

            BasicFormField(
                value = uiState.noWhatsappPengirim,
                onValueChange = {
                    onEvent(FormPengantaranBarangEvent.ChangeNoWhatsappPengirim(it))
                },
                placeholder = "No. Whatsapp Pengirim",
                modifier = Modifier
                    .fillMaxWidth()
            )

            BasicFormField(
                value = uiState.namaPenerima,
                onValueChange = {
                    onEvent(FormPengantaranBarangEvent.ChangeNamaPenerima(it))
                },
                placeholder = "Nama Penerima",
                modifier = Modifier
                    .fillMaxWidth()
            )

            BasicFormField(
                value = uiState.alamatPengantaran,
                onValueChange = {
                    onEvent(FormPengantaranBarangEvent.ChangeAlamatPengantaran(it))
                },
                placeholder = "Alamat Pengantaran",
                modifier = Modifier
                    .fillMaxWidth()
            )

            BasicFormField(
                value = uiState.noWhatsappPenerima,
                onValueChange = {
                    onEvent(FormPengantaranBarangEvent.ChangeNoWhatsappPenerima(it))
                },
                placeholder = "No. Whatsapp Penerima",
                modifier = Modifier
                    .fillMaxWidth()
            )

            BasicFormField(
                value = uiState.detailPaket,
                onValueChange = {
                    onEvent(FormPengantaranBarangEvent.ChangeDetailPaket(it))
                },
                placeholder = "Detail Paket",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        OrderButton(
            onClick = {
                onEvent(FormPengantaranBarangEvent.ClickOrder)
            },
            modifier = Modifier
                .padding(
                    vertical = 36.dp,
                    horizontal = 24.dp
                )
                .fillMaxWidth()
        )
    }
}