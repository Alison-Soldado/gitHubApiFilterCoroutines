package com.example.githubapifiltercourotines.domain.model

data class RepositoryVO(
    val id: Long,
    var name: String,
    val full_name: String,
    val owner: OwnerVO,
    val html_url: String,
    val description: String,
    var forks_count: Long,
    var stargazers_count: Long,
    var open_issues: Long
)

data class OwnerVO(
    val id: Long,
    val login: String,
    val avatar_url: String,
    val url: String,
    val htmlUrl: String
)