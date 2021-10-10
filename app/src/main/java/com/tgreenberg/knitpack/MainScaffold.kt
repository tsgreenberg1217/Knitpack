package com.tgreenberg.knitpack

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScaffold() {
    Scaffold(
        isFloatingActionButtonDocked = true,
        topBar = {
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
                            Icons.Filled.Add,
                            contentDescription = ""
                        )
                    }
                }
            )
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
                        tint = Color(131, 52, 71)
                    )
                },
                    label = {
                        Text(text = "Label")
                    })

                BottomNavigationItem(selected = true, onClick = { }, icon = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "",
                        tint = Color(131, 52, 71),

                        )
                },
                    label = {
                        Text(text = "Label")
                    })

                Spacer(Modifier.weight(1f, true))

                BottomNavigationItem(selected = true, onClick = { }, icon = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "",
                        tint = Color(131, 52, 71)
                    )
                },
                    label = {
                        Text(text = "Label")
                    })

                BottomNavigationItem(selected = true, onClick = { }, icon = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "",
                        tint = Color(131, 52, 71)
                    )
                },
                    label = {
                        Text(text = "Label")
                    })
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                    tint = Color(131, 52, 71)
                )
            }
        }
    ) {

    }
}


@Preview
@Composable
fun previewMainScaffold() {
    MainScaffold()
}