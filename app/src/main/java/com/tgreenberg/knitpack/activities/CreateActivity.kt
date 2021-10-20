package com.tgreenberg.knitpack.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.create_page.CreateProjectPage
import com.example.knitpack_components.KnitFormUI
import com.example.knitpacktheme.theme.KnitPackTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutine = rememberCoroutineScope()
            KnitPackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CreateProjectPage(submitProject = {
                        coroutine.launch {
                            KnitPackApi.postProject(it)
                        }
                    })
                }

            }
        }
    }
}


@Preview
@Composable fun checkitout(){
    KnitFormUI.KnitPictures()
}