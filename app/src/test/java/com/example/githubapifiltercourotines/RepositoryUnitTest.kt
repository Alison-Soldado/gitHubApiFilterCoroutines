package com.example.githubapifiltercourotines

import com.example.githubapifiltercourotines.config.remoteModule
import com.example.githubapifiltercourotines.config.repositoryModule
import com.example.githubapifiltercourotines.config.uiModule
import com.example.githubapifiltercourotines.ui.repository.RepositoryViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryUnitTest : KoinTest {

    private val repositoryViewModel : RepositoryViewModel by inject()
    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, uiModule)
    }

    @Before
    fun setup() {}

    @After
    fun shutdown() {
    }

    @Test
    fun givenWhenThen() {

    }

}
