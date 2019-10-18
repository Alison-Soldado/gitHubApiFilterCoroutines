package com.example.githubapifiltercourotines.resource.remote.parse

import com.example.githubapifiltercourotines.domain.model.OwnerVO
import com.example.githubapifiltercourotines.domain.model.RepositoryVO
import com.example.githubapifiltercourotines.resource.remote.response.Items
import com.example.githubapifiltercourotines.resource.remote.response.Owner

fun Items.toModel() : RepositoryVO {
    return RepositoryVO(
        this.id,
        this.name,
        this.full_name,
        this.owner.toModel(),
        this.html_url,
        this.description,
        this.forks_count,
        this.stargazers_count,
        this.open_issues
    )
}

fun Owner.toModel() : OwnerVO {
    return OwnerVO(
        this.id,
        this.login,
        this.avatar_url,
        this.url,
        this.htmlUrl
    )
}