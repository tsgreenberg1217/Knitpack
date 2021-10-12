package com.tgreenberg.knitpack

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun MainKnitingPage(
    navController: NavHostController,
    viewModel: MainPageViewModel
) {
    when(val routeClass = viewModel.mainRoute.value){
        is MainPageRoute.AddProject -> {
            navController.navigate(routeClass.route)
        }
    }
    NavHost(
        navController = navController,
        startDestination = MainPageRoute.MyProjects.route,
        Modifier.padding(12.dp)
    ) {
        composable(MainPageRoute.MyProjects.route) {
            ProjectsPath()
        }
        composable(MainPageRoute.AllProjects.route) {
            DummyView(MainPageRoute.AllProjects.route)
        }
        composable(MainPageRoute.Misc.route) {
            DummyView(MainPageRoute.Misc.route)
        }

    }
}


sealed class MainPageRoute(val route: String, @StringRes val resId: Int) {
    object MyProjects : MainPageRoute("myprojects", R.string.my_projects_title)
    object AllProjects : MainPageRoute("allprojects", R.string.all_projects_title)
    object Misc : MainPageRoute("misc", R.string.misc_title)
    object AddProject : MainPageRoute("addProjectRoute", R.string.add_project)
}


@Composable
fun ProjectsPath() {
    val projectNav = rememberNavController()

    NavHost(
        navController = projectNav,
        startDestination = MainPageRoute.MyProjects.route
    ) {
        composable(MainPageRoute.MyProjects.route) {
            DummyView(MainPageRoute.AllProjects.route)
        }
        composable(MainPageRoute.AddProject.route) {
            AddProjectPage { proj ->
                KnitPackApi.postProject(proj)
            }
        }
    }
}