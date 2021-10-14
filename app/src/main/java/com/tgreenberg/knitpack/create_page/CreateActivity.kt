package com.tgreenberg.knitpack.create_page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.tgreenberg.knitpack.ui.theme.KnitPackTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

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