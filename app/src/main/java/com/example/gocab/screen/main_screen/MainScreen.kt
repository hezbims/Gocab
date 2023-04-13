package com.example.gocab.screen.main_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gocab.MainScreenEvent
import com.example.gocab.MainViewModel
import com.example.gocab.R
import com.example.gocab.route.NavigationRoute
import com.example.gocab.ui.theme.GocabTheme

@Composable
fun MainScreen(
    viewModel : MainViewModel = hiltViewModel(),
    navController : NavHostController,
){
    MainScreen(
        onEvent = viewModel::onEvent,
        navController = navController
    )
}

@Composable
private fun MainScreen(
    onEvent : (MainScreenEvent) -> Unit,
    navController: NavHostController,
){
    Column(
        modifier = Modifier
            .padding(
                vertical = 16.dp,
                horizontal = 24.dp
            )
            .verticalScroll(rememberScrollState())
    ) {
        Banner(
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

        LayananScreen(
            onEvent = onEvent,
            navController = navController
        )

        Footer(
            modifier = Modifier
                .padding(top = 16.dp)
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
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .height(136.dp)
            .background(Color(0x26159CBC))
            .clickable { onClick() }

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .padding(vertical = 14.dp , horizontal = 8.dp)
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

@Composable
private fun LayananScreen(
    onEvent : (MainScreenEvent) -> Unit,
    navController: NavHostController
){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.gocab_label),
            contentDescription = null,
            modifier = Modifier
                .height(12.dp)
                .width(68.dp)
        )
        Text(
            text = "4 layanan yang tersedia",
            fontSize = 9.sp
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(top = 8.dp)
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
                    onClick = {
                        navController.navigate(NavigationRoute.formOjekRoute)
                    }
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
private fun Banner(
    modifier: Modifier = Modifier
){
    Card(
        backgroundColor = Color(0xFFD4DFE4),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.gocab_banner_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Image(
                painter = painterResource(id = R.drawable.gocab_banner_driver),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(130.dp)
                    .height(119.dp)
                    .align(Alignment.BottomEnd)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(11.dp),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(
                        top = 17.dp,
                        bottom = 17.dp,
                        start = 24.dp
                    )
            ) {
                Text(
                    text = "Ojek , Delivery Makanan\nSampai Antar Paket",
                    color = Color(0xFF0D6277),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )

                Text(
                    text = headerText(),
                    fontSize = 11.sp
                )

                TextButton(
                    onClick = {

                    },
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color(0xFF0D6277)
                    )
                ) {
                    Text(
                        text = "Buruan Order Via Gocab Delivery",
                        color = Color(0xFF0D6277),
                        fontSize = 9.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun Footer(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF1996B4),
                            Color(0xFF1F93AF),
                            Color(0xFF15B0D7)
                        )
                    )
                )
                .padding(
                    vertical = 14.dp,
                    horizontal = 45.dp
                )
        ){
            Text(
                text = "Online Delivery",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "#Cepat dan Murah",
                fontSize = 10.sp,
                color = Color.White
            )

            TextButton(
                onClick = {

                },
                border = BorderStroke(
                    width = 1.dp ,
                    color = Color(0xFF3CD2F8)
                ),
                contentPadding = PaddingValues(
                    vertical = 5.5.dp,
                    horizontal = 8.dp
                ),
                modifier = Modifier
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "Pesan Sekarang",
                    color = Color.White,
                    fontSize = 9.sp
                )
            }
        }

        Image(
            painter = painterResource(
                id = R.drawable.gocab_driver_biru
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .width(169.dp)
                .height(184.dp)
        )
    }
}

@Composable
@Preview
private fun MainScreenPreview(){
    GocabTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MainScreen(
                onEvent = {},
                navController = rememberNavController()
            )
        }
    }
}

@Composable
@Preview
private fun BannerPreview(){
    GocabTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Banner()
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

private fun headerText() : AnnotatedString = buildAnnotatedString {
    withStyle(
        SpanStyle(fontSize = 11.sp)
    ){
        append("Cuma Start ")
    }

    withStyle(
      SpanStyle(
          fontSize = 19.sp,
          color = Color(0xFFF56D11),
          fontWeight = FontWeight.Bold
      )
    ){
        append("5rb ")
    }

    withStyle(
        SpanStyle(fontSize = 11.sp)
    ){
        append("Aja Loh")
    }

}