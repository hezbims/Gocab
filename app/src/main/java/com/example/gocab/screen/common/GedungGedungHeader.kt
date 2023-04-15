package com.example.gocab.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gocab.R

@Composable
fun GedungGedungHeader(
    onBackPressed : () -> Unit,
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
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            CircleBackButton(
                onBackPressed = onBackPressed,
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 24.dp
                    )
            )

            GocabFullImage(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        end = 24.dp
                    )
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

@Composable
private fun CircleBackButton(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        shape = CircleShape
    ) {
        IconButton(
            onClick = onBackPressed,
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun GocabFullImage(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
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
}