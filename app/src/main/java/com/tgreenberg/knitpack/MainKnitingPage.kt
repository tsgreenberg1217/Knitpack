package com.tgreenberg.knitpack

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainKnitingPage(navController: NavHostController) {
    val barItems = listOf(
        MainPages.MyProjects,
        MainPages.AllProjects,
        MainPages.Misc
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination: NavDestination? = navBackStackEntry?.destination
                barItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(MainPages.MyProjects.route) {
                                    inclusive = false
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = "") }
                    )
                }
            }
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = MainPages.MyProjects.route, Modifier.padding(it)
        ) {
            composable(MainPages.MyProjects.route) {
                val projectNav = rememberNavController()
                val addProjectRoute = "addProjectRoute"
                NavHost(
                    navController = projectNav,
                    startDestination = MainPages.MyProjects.route
                ) {
                    composable(MainPages.MyProjects.route) {
                        KnittingProjects { projectNav.navigate(addProjectRoute) }
                    }
                    composable(addProjectRoute) {
                        AddProjectPage { proj ->
                            KnitPackApi.postProject(proj)
                        }
                    }
                }
            }
            composable(MainPages.AllProjects.route) {
                DummyView(MainPages.AllProjects.route)
            }
            composable(MainPages.Misc.route) {
                DummyView(MainPages.Misc.route)
            }
        }

    }
}

sealed class MainPages(val route: String, @StringRes val resId: Int) {
    object MyProjects : MainPages("myprojects", R.string.my_projects_title)
    object AllProjects : MainPages("allprojects", R.string.all_projects_title)
    object Misc : MainPages("misc", R.string.misc_title)
}