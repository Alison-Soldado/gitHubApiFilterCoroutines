package com.example.githubapifiltercourotines.resource.remote.source

import com.example.githubapifiltercourotines.domain.source.RepositoryDataSource
import com.example.githubapifiltercourotines.resource.remote.api.GithubApi
import com.example.githubapifiltercourotines.resource.remote.parse.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryDataSourceImpl(private val api: GithubApi) : RepositoryDataSource {

    override suspend fun getRepository(page: Int) = withContext(Dispatchers.IO) {
        api.getRepositoryAsync(page).await().items.map { it.toModel() }
    }
}