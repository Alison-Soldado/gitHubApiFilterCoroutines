package com.example.githubapifiltercourotines.domain.source

import com.example.githubapifiltercourotines.domain.model.RepositoryVO

interface RepositoryDataSource {
    suspend fun getRepository(page: Int): List<RepositoryVO>
}