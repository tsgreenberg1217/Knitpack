package com.tgreenberg.knitpack.activities


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.mainpage.MainKnitingPage
import com.example.mainpage.MainPageViewModel
import com.example.mainpage.MainScaffold
import com.tgreenberg.knitpack.create_page.CreateActivity
import com.example.knitpacktheme.theme.KnitPackTheme
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

                    MainScaffold(
                        navController = navController,
                        onAdd = {
                            startActivity(Intent(this, CreateActivity::class.java))
                        }
                    ) {
                        MainKnitingPage(
                            navController = navController,
                            viewModel = mainPageViewModel
                        )
                    }
                }
            }
        }
    }
}
