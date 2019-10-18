package com.example.githubapifiltercourotines.domain.model

data class RepositoryVO(
    val id: Long,
    val name: String,
    val full_name: String,
    val owner: OwnerVO,
    val html_url: String,
    val description: String,
    val forks_count: Long,
    val stargazers_count: Long,
    val open_issues: Long
)

data class OwnerVO(
    val id: Long,
    val login: String,
    val avatar_url: String,
    val url: String,
    val htmlUrl: String
)