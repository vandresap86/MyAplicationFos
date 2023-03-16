package com.example.myapplication.presentation

import androidx.lifecycle.*
import com.example.myapplication.data.model.ProjectList
import com.example.myapplication.repository.ProjectRepository
import kotlinx.coroutines.launch

class ProjectViewModel(private val repo: ProjectRepository): ViewModel() {

    private val _project = MutableLiveData<ProjectList>()
    val project: LiveData<ProjectList> get() = _project

    init {
        viewModelScope.launch {
            _project.value = repo.getProject()
        }
    }

}

class ProjectViewModelFactory(private val repo: ProjectRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ProjectRepository::class.java).newInstance(repo)
    }
}