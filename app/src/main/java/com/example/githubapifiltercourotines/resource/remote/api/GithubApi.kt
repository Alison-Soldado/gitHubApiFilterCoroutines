package com.example.githubapifiltercourotines.resource.remote.api

import com.example.githubapifiltercourotines.resource.remote.response.Result
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories?q=language:Kotlin&sort=stars&")
    fun getRepositoryAsync(@Query("page") page: Int): Deferred<Result>
}