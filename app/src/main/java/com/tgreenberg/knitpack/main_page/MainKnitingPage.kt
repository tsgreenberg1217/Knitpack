package com.tgreenberg.knitpack.main_page


import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tgreenberg.knitpack.R

@Composable
fun MainKnitingPage(
    navController: NavHostController,
    viewModel: MainPageViewModel
) {
    NavHost(
        navController = navController,
        startDestination = MainPageRoute.Patterns.route,
        Modifier.padding(12.dp)
    ) {

        composable(MainPageRoute.Patterns.route) {
            DummyView(MainPageRoute.Patterns.route)
        }

        composable(MainPageRoute.Tutorials.route) {
            DummyView(MainPageRoute.Tutorials.route)
        }

        composable(MainPageRoute.Social.route) {
            DummyView(MainPageRoute.Social.route)
        }

        composable(MainPageRoute.Personal.route) {
            DummyView(MainPageRoute.Personal.route)
        }

    }
}


sealed class MainPageRoute(val route: String, @StringRes val resId: Int) {
    object Patterns : MainPageRoute("route_patterns", R.string.title_patterns)
    object Tutorials : MainPageRoute("route_tutorials", R.string.title_tutorials)
    object Social : MainPageRoute("route_social", R.string.title_social)
    object Personal : MainPageRoute("route_personal", R.string.title_personal)
}
