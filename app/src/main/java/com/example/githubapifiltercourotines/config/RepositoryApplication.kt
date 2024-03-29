package com.example.githubapifiltercourotines.config

import android.app.Application
import org.koin.android.ext.android.startKoin


open class RepositoryApplication : Application() {

    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, uiModule)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}