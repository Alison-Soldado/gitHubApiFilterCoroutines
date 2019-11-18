package com.example.githubapifiltercourotines

import com.example.githubapifiltercourotines.config.remoteModule
import com.example.githubapifiltercourotines.config.repositoryModule
import com.example.githubapifiltercourotines.config.uiModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryUnitTest : KoinTest {

    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, uiModule)
    }

    @Before
    fun setup() {
        startKoin { }
    }

    @After
    fun shutdown() {
        stopKoin()
    }

    @Test
    fun givenWhenThen() {

    }

}
