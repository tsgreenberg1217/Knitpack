package com.tgreenberg.knitpack

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tgreenberg.knitpack.ui.theme.Mid_Grey
import com.tgreenberg.knitpack.ui.theme.Mulberry_Primary
import com.tgreenberg.knitpack.ui.theme.Off_White

@Composable
fun MainScaffold(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    val mainViewModel = hiltViewModel<MainPageViewModel>()
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
                BottomNavigationItem(selected = true, onClick = { }, icon = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "",
                    )
                },
                    label = {
                        Text(text = "Label", color = MaterialTheme.colors.primary)
                    },
                    selectedContentColor = Mulberry_Primary,
                    unselectedContentColor = Mid_Grey
                )

                BottomNavigationItem(selected = false, onClick = { }, icon = {
                    Icon(
                        painterResource(KnitPackIcons.PLAY_CIRCLE),
                        contentDescription = "",
                    )
                },
                    label = {
                        Text(text = "Tutorials")
                    },
                    selectedContentColor = Mulberry_Primary,
                    unselectedContentColor = Mid_Grey
                )

                Spacer(Modifier.weight(1f, true))

                BottomNavigationItem(
                    selected = false, onClick = { },
                    icon = {
                        Icon(
                            painter = painterResource(id = KnitPackIcons.GROUP),
                            contentDescription = "",
                        )
                    },
                    label = {
                        Text(text = "Social")
                    },
                    selectedContentColor = Mulberry_Primary,
                    unselectedContentColor = Mid_Grey
                )

                BottomNavigationItem(selected = false, onClick = { }, icon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "",
                    )
                },
                    label = {
                        Text(text = "Personal")
                    },
                    selectedContentColor = Mulberry_Primary,
                    unselectedContentColor = Mid_Grey
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { mainViewModel.setPage(MainPageRoute.AddProject) },
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