package com.example.gocab.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gocab.MainScreenEvent
import com.example.gocab.MainViewModel
import com.example.gocab.R

@Composable
fun MainScreen(
    viewModel : MainViewModel = hiltViewModel()
){
    MainScreen(onEvent = viewModel::onEvent)
}

@Composable
private fun MainScreen(
    onEvent : (MainScreenEvent) -> Unit
){
    Column {
        LayananScreen(
            onEvent = onEvent
        )
    }
}

@Composable
private fun KartuPilihan(
    imageId : Int,
    label : String,
    modifier : Modifier = Modifier,
    onClick : () -> Unit,
){
    Card(
        modifier = modifier
            .height(136.dp)
            .clickable { onClick() }
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Card(
                    shape = CircleShape,
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .size(56.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = imageId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }
                }
                Text(
                    text = label,
                    color = Color(0xFF15B0D7),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun LayananScreen(
    onEvent : (MainScreenEvent) -> Unit
){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(
                vertical = 16.dp,
                horizontal = 24.dp
            )
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                KartuPilihan(
                    imageId = R.drawable.pengantaran,
                    label = "Pengantaran Barang",
                    modifier = Modifier.weight(1f),
                    onClick = { onEvent(MainScreenEvent.CallKirimPaket) }
                )

                KartuPilihan(
                    imageId = R.drawable.pesan_makan,
                    label = "Pesan Makan/Barang",
                    modifier = Modifier.weight(1f),
                    onClick = { onEvent(MainScreenEvent.CallDeliveryMakananBarang) }
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                KartuPilihan(
                    imageId = R.drawable.ojek,
                    label = "Ojek",
                    modifier = Modifier.weight(1f),
                    onClick = { onEvent(MainScreenEvent.CallOjek) }
                )

                KartuPilihan(
                    imageId = R.drawable.produk_umkm,
                    label = "Produk UMKM",
                    modifier = Modifier.weight(1f),
                    onClick = { onEvent(MainScreenEvent.Umkm) }
                )
            }
        }
    }
}

@Composable
@Preview
private fun LayananScreenPreview(){
    GocabTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LayananScreen(onEvent = {})
        }
    }
}
@Composable
@Preview
private fun KartuPilihanPreview(){
    GocabTheme {
        Surface {
            KartuPilihan(
                imageId = R.drawable.pengantaran,
                label = "Pengantaran"
            ){}
        }
    }
}