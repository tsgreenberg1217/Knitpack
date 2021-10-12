package com.tgreenberg.knitpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tgreenberg.knitpack.ui.theme.*

@Composable
fun TabView() {
    var text by rememberSaveable { mutableStateOf("") }
    val textStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.amiko_semibold)),
        color = Off_Black
    )
    Box(
        Modifier.background(Mulberry_Light)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp)
        ) {


            TextField(
                value = text,
                onValueChange = {text = it},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Mulberry_Mid,
                    focusedIndicatorColor = Mulberry_Primary,
                    unfocusedIndicatorColor = Light_Grey
                ),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "",
                        tint = Off_White,
                    )
                },
                placeholder = {
                    Text(
                        color = Off_White,
                        text = "Search all patterns",
                    )
                },
                textStyle = TextStyle(
                    color = Off_White
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Category", textAlign = TextAlign.Center, modifier = Modifier.weight(1f), style = textStyle)
                Text("Level", textAlign = TextAlign.Center, modifier = Modifier.weight(1f), style = textStyle)
                Text("Saved", textAlign = TextAlign.Center, modifier = Modifier.weight(1f), style = textStyle)
            }
        }
    }
}


@Preview
@Composable
fun previewTabView() {
    Surface() {
        TabView()
    }
}

