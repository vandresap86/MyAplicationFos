package com.example.myapplication.repository

import com.example.myapplication.R
import com.example.myapplication.data.model.ProjectList
import com.example.myapplication.data.model.Projects
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProjectRepositoryImpl: ProjectRepository{
    override suspend fun getProject(): ProjectList {

        return withContext(Dispatchers.Default) {
            exampleListProject()
        }

    }

    private fun exampleListProject(): ProjectList {
        val project1 = Projects(
            "San Lorenzo 1",
            R.drawable.ic_launcher_background,
            "150 departamentos",
            "Av. Sanlorenzo s/n"
        )
        val project2 = Projects(
            "San Lorenzo 2",
            R.drawable.ic_launcher_background,
            "40 departamentos",
            "Av Sanlorenzo 1990"
        )
        val project3 = Projects(
            "San Lorenzo 3",
            R.drawable.ic_launcher_background,
            "100 departamentos",
            "Av Salorenzo 15640"
        )
        val project4 = Projects(
            "Eugenia",
            R.drawable.ic_launcher_background,
            "15 departamentos",
            "Metro Eugenia"
        )
        val project5 = Projects(
            "Atlalilco",
            R.drawable.ic_launcher_background,
            "25 departamentos",
            "Avenida Iztapalapa"
        )
        val project6 = Projects(
            "Moctezuma",
            R.drawable.ic_launcher_background,
            "20 departamentos",
            "Metro moctezuma"
        )

        return ProjectList(
            listOf(
                project1,
                project2,
                project3,
                project4,
                project5,
                project6
            )
        )

    }

}