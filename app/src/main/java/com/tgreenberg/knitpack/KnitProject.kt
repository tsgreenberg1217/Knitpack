package com.tgreenberg.knitpack

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tgreenberg.knitpack.DataSource.getProjectTxts
import com.tgreenberg.core.models.ProjectTxt

@Composable
fun KnittingProjects(
    addNewProject: () -> Unit
) {
    val projectsData = remember { getProjectTxts() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp)
    ) {
        KnittingProjectsList(
            projectsData,
            Modifier.weight(1f)
        )
        Button(
            onClick = { addNewProject() },
        ) {
            Text(text = "Add Project")
        }
    }
}


@Composable
fun KnittingProjectsList(projects: List<ProjectTxt>, modifier: Modifier) {
    // A surface container using the 'background' color from the theme
    LazyColumn(modifier = modifier) {
        itemsIndexed(projects) { i, project ->
            KnitProjectCard(project)
        }
    }
}

@Composable
fun KnitProjectCard(project: ProjectTxt) {

    Surface(modifier = Modifier.padding(all = 4.dp)) {
        Row(
            modifier = Modifier
                .border(1.dp, Color.Blue, shape = RoundedCornerShape(4.dp))
                .height(100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = project.name )
            }
            Spacer(Modifier.width(4.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "${project.steps.size} steps",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
                    )
                )
                Text(
                    text = project.level,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Gray
                    )
                )
            }
        }
    }

}

//@Composable
//fun KnitProjectCard(img: Int, name: String, level: String) {
//
//    Surface(modifier = Modifier.padding(all = 4.dp)) {
//        Row(
//            modifier = Modifier
//                .border(1.dp, Color.Blue, shape = RoundedCornerShape(4.dp))
//                .height(100.dp)
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Image(
//                painter = painterResource(id = img),
//                contentDescription = "Hat project",
//                modifier = Modifier
//                    .size(100.dp)
//                    .padding(all = 5.dp),
//            )
//            Spacer(Modifier.width(4.dp))
//            Column(
//                verticalArrangement = Arrangement.Center,
//                modifier = Modifier.fillMaxHeight()
//            ) {
//                Text(
//                    text = name,
//                    style = TextStyle(
//                        fontSize = 22.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.DarkGray
//                    )
//                )
//                Text(
//                    text = level,
//                    style = TextStyle(
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Light,
//                        color = Color.Gray
//                    )
//                )
//            }
//        }
//    }
//
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    KnitPackTheme {
//        KnittingProjects()
//    }
//}