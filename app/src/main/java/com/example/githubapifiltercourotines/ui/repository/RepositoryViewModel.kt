package com.example.githubapifiltercourotines.ui.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapifiltercourotines.domain.model.RepositoryVO
import com.example.githubapifiltercourotines.domain.source.RepositoryDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class RepositoryViewModel(private val repository: RepositoryDataSource) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModeScope = CoroutineScope(Main + viewModelJob)

    private val _repositories: MutableLiveData<MutableList<RepositoryVO>> = MutableLiveData()
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    val repositories: LiveData<MutableList<RepositoryVO>> get() = _repositories
    val loading: LiveData<Boolean> get() = _loading
    val error: LiveData<Throwable> get() = _error

    fun getRepository() {
        _loading.value = true
        viewModeScope.launch {
            try {
                _repositories.value = repository.getRepository(1).toMutableList()
                _loading.value = false
            } catch (throwable: Throwable) {
                _repositories.value = mutableListOf()
                _error.value = throwable
            } finally {
                _loading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}