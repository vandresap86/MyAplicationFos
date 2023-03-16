package com.example.myapplication.repository

import com.example.myapplication.data.model.ProjectList

interface ProjectRepository {
    suspend fun getProject(): ProjectList
}