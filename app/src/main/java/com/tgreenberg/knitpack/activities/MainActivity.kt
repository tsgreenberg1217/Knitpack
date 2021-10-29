package com.tgreenberg.knitpack.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.knitpack_components.KnitNavRoutes
import com.example.knitpack_components.MainScaffold
import com.example.mainpage.MainKnitingPage
import com.example.mainpage.MainPageViewModel
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
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination: NavDestination? = navBackStackEntry?.destination
//                    Log.d("Backstack test", "${navController.backQueue.map { it.destination.route }} ")


                    MainScaffold(
                        onAdd = {
                            startActivity(Intent(this, CreateActivity::class.java))
                        },
                        isSelected = { selectedRoute ->
                            currentDestination?.hierarchy?.any { h -> h.route == selectedRoute } ?: false
                        },
                        onNavigate = { route ->
                            navController.navigate(route) {
                                popUpTo(KnitNavRoutes.PatternsRoutes.PatternFirst.route)
                            }

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
