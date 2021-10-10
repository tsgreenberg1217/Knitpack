package com.tgreenberg.knitpack

import androidx.compose.runtime.mutableStateListOf
import com.tgreenberg.core.models.ProjectTxt


data class Project(
    val img: Int, val name: String, val level: String
)

object DataSource {
    fun getProjects(): List<Project> = listOf(
        Project(R.drawable.hat_1, "Garter Hat", "Beginner"),
        Project(R.drawable.sarf_1, "Seed Stitch Hat", "Intermediate"),
        Project(R.drawable.hat_2, "Textured Hat", "Advanced")
    )

    fun getProjectTxts() = mutableStateListOf(
        ProjectTxt(
            "Garter Hat",
            listOf("", "", "", ""),
            "Beginner"
        ),
        ProjectTxt(
            "Seed Stitch Hat",
            listOf("", "", "", "", ""),
            "Intermediate"
        ),
        ProjectTxt(
            "Textured Hat",
            listOf("", "", "", ""),
            "Advanced"
        )
    )
}