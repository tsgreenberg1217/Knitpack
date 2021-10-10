package com.tgreenberg.knitpack

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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