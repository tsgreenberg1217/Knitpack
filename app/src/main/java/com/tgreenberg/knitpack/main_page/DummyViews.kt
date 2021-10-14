package com.tgreenberg.knitpack.main_page


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable fun DummyView(route:String){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(route)
    }
}