package com.example.gocab.screen.form_ojek_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gocab.R
import com.example.gocab.screen.BasicFormField

@Composable
fun FormOjekScreen(
    viewModel: FormOjekViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsState().value
    FormOjekScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun FormOjekScreen(
    uiState: FormOjekUiState,
    onEvent : (FormOjekEvent) -> Unit,
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Header(
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
                placeholder = "Nomor Whatsapp",
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        Button(
            onClick = {
                onEvent(FormOjekEvent.ClickOrder)
            },
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 36.dp
                )
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 14.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Order")
        }
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .background(
                color = Color(0x730A3945)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(
                    top = 16.dp,
                    start = 24.dp
                )
        ){
            Image(
                painter = painterResource(
                    id = R.drawable.logo_gocab
                ),
                contentDescription = null,
                modifier = Modifier
                    .width(42.dp)
                    .height(27.dp)
            )

            Image(
                painter = painterResource(
                    id = R.drawable.gocab_label
                ),
                contentDescription = null,
                modifier = Modifier
                    .width(68.dp)
                    .height(12.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.gocab_gedung_gedung),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun FormOjekScreenPreview(){

}