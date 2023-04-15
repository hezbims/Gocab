package com.example.gocab.screen.form_delivery_makanan_screen

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
fun FormDeliveryMakananScreen(
    viewModel: FormDeliveryMakananViewModel = hiltViewModel(),
    navController: NavHostController
){
    val uiState = viewModel.uiState.collectAsState().value
    
    FormDeliveryMakananScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent,
        navController = navController
    )
}

@Composable
private fun FormDeliveryMakananScreen(
    uiState: FormDeliveryMakananUiState,
    onEvent : (FormDeliveryMakananEvent) -> Unit,
    navController : NavHostController
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        GedungGedungHeader(
            onBackPressed = { navController.popBackStack() }
        )

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
                value = uiState.namaPelanggan,
                onValueChange = {
                    onEvent(FormDeliveryMakananEvent.ChangeNamaPelanggan(it))
                },
                placeholder = "Nama Pelanggan",
                modifier = Modifier.fillMaxWidth()
            )

            BasicFormField(
                value = uiState.alamatPembelian,
                onValueChange = {
                    onEvent(FormDeliveryMakananEvent.ChangeAlamatPembelian(it))
                },
                placeholder = "Alamat Pembelian",
                modifier = Modifier.fillMaxWidth()
            )

            BasicFormField(
                value = uiState.alamatPengantaran,
                onValueChange = {
                    onEvent(FormDeliveryMakananEvent.ChangeAlamatPengantaran(it))
                },
                placeholder = "Alamat Pengantaran",
                modifier = Modifier.fillMaxWidth()
            )

            BasicFormField(
                value = uiState.detailOrderan,
                onValueChange = {
                    onEvent(FormDeliveryMakananEvent.ChangeDetailOrderan(it))
                },
                placeholder = "Detail dan Jumlah Orderan",
                modifier = Modifier.fillMaxWidth()
            )

            BasicFormField(
                value = uiState.noWhatsapp,
                onValueChange = {
                    onEvent(FormDeliveryMakananEvent.ChangeNoWhatsapp(it))
                },
                placeholder = stringResource(
                    id = R.string.placeholder_no_whatsapp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        OrderButton(
            onClick = {
                onEvent(FormDeliveryMakananEvent.ClickOrder)
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

