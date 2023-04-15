package com.example.gocab.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gocab.ui.theme.GocabTheme

@Composable
fun BasicFormField(
    value : String,
    onValueChange : (String) -> Unit,
    placeholder : String,
    modifier: Modifier = Modifier
){
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .background(
                        color = Color(0x1A43D7FC),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp)
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium)
                    )
                }
                innerTextField()  //<-- Add this
            }
        },
    )
}

@Composable
@Preview
fun BasicFormFieldPreview(){
    GocabTheme {
        Surface(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            BasicFormField(
                value = "",
                placeholder = "Alamat pengiriman",
                onValueChange = {}
            )
        }
    }
}