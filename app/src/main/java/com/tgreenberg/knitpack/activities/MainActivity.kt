package com.tgreenberg.knitpack.activities


import android.content.Intent
import android.os.Bundle
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
import com.example.knitpack_components.MainPageRoute
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
                    MainScaffold(
                        onAdd = {
                            startActivity(Intent(this, CreateActivity::class.java))
                        },
                        isSelected = { selectedRoute ->
                            currentDestination?.hierarchy?.any { h -> h.route == selectedRoute } == true
                        },
                        onNavigate = { route ->
                            navController.navigate(route) {
                                popUpTo(MainPageRoute.Patterns.route) { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
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
