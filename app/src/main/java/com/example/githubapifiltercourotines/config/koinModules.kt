package com.example.githubapifiltercourotines.config

import com.example.githubapifiltercourotines.domain.source.RepositoryDataSource
import com.example.githubapifiltercourotines.resource.remote.api.GithubApi
import com.example.githubapifiltercourotines.resource.remote.source.RepositoryDataSourceImpl
import com.example.githubapifiltercourotines.ui.repository.RepositoryViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val uiModule = module {
    viewModel { RepositoryViewModel(get()) }
}

val repositoryModule = module {
    single<RepositoryDataSource> { RepositoryDataSourceImpl(get()) }
}

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { createApi<GithubApi>(get()) }
}