package com.tgreenberg.knitpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.tgreenberg.knitpack.ui.theme.KnitPackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KnitPackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val mainPageViewModel = hiltViewModel<MainPageViewModel>()
                    val navController = rememberNavController()

                    MainScaffold(navController = navController){
                        MainKnitingPage(
                            navController = navController,
                            viewModel = mainPageViewModel)
                    }
                }
            }
        }
    }
}
