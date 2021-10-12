package com.tgreenberg.knitpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    val navControler = rememberNavController()

                    MainScaffold(navController = navControler){
                        MainKnitingPage(
                            navController = navControler,
                            viewModel = mainPageViewModel)
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun mainPreview() {
//    KnitPackTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            val navControler = rememberNavController()
//            MainKnitingPage(navControler)
//        }
//    }
//}
