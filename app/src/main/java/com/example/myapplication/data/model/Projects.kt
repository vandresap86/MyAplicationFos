package com.example.myapplication.data.model

import com.example.myapplication.R

data class Projects(
    val nameProject: String,
    val imageProject: Int,
    val description: String,
    val direction: String)

data class ProjectList(val results: List<Projects> = listOf())
