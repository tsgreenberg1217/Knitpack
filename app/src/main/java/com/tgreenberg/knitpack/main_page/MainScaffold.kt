package com.tgreenberg.knitpack.main_page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tgreenberg.knitpack.KnitPackIcons
import com.tgreenberg.knitpack.ui.theme.Mid_Grey
import com.tgreenberg.knitpack.ui.theme.Mulberry_Primary
import com.tgreenberg.knitpack.ui.theme.Off_White

data class MainIconData(
    val iconRes: Int,
    val route: MainPageRoute
)

val iconList = listOf(
    MainIconData(KnitPackIcons.LOYALTY, MainPageRoute.Patterns),
    MainIconData(KnitPackIcons.PLAY_CIRCLE, MainPageRoute.Tutorials),
    MainIconData(KnitPackIcons.GROUP, MainPageRoute.Social),
    MainIconData(KnitPackIcons.PERSON, MainPageRoute.Personal)
)

@Composable
fun MainScaffold(
    navController: NavHostController,
    onAdd: () -> Unit,
    content: @Composable () -> Unit
) {
    val mainViewModel = hiltViewModel<MainPageViewModel>()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination: NavDestination? = navBackStackEntry?.destination
    Scaffold(
        isFloatingActionButtonDocked = true,
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "App bar")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = ""
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Notifications,
                                contentDescription = ""
                            )
                        }
                    },
                    backgroundColor = MaterialTheme.colors.background,
                    elevation = 0.dp
                )
                TabView()
            }

        },
        bottomBar = {

            BottomAppBar(
                backgroundColor = Color.LightGray,
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                ),
                contentPadding = PaddingValues(all = 0.dp)
            ) {

                iconList.forEach {
                    val descString = stringResource(id = it.route.resId)
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { h -> h.route == it.route.route } == true,
                        onClick = {
                            navController.navigate(it.route.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(MainPageRoute.Patterns.route) {
                                    inclusive = false
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painterResource(id = it.iconRes),
                                contentDescription = descString,
                            )
                        },
                        label = {
                            Text(text = descString, color = MaterialTheme.colors.primary)
                        },
                        selectedContentColor = Mulberry_Primary,
                        unselectedContentColor = Mid_Grey
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAdd() },
                backgroundColor = Mulberry_Primary
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                    tint = Off_White
                )
            }
        }
    ) {
        content()
    }
}


@Preview
@Composable
fun previewMainScaffold() {
//    MainScaffold {
//
//    }
}