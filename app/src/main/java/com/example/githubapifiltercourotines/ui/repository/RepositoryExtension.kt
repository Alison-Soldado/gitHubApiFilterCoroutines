package com.example.githubapifiltercourotines.ui.repository

fun RepositoryAdapter.filterForName() {
    repositories.sortBy { it.name.toUpperCase() }
    notifyDataSetChanged()
}

fun RepositoryAdapter.filterForStar() {
    repositories.maxBy { it.stargazers_count }
    notifyDataSetChanged()
}

fun RepositoryAdapter.filterForStarCount() {
    val listFilter = repositories
        .asSequence()
        .filter { it.stargazers_count > 100 }
        .map { it.name.plus(" Soldado") }
        .toList()

    for (i in listFilter.indices) {
        repositories[i].name = listFilter[i]
    }
    notifyDataSetChanged()
}

fun RepositoryAdapter.filterAddition() {
    val listFilter = repositories
        .asSequence()
        .filter { it.forks_count > 200 }
        .map { it.forks_count + 2 }
        .toList()

    for (i in listFilter.indices) {
        repositories[i].forks_count = listFilter[i]
    }
    notifyDataSetChanged()
}

fun RepositoryAdapter.filterMultiple() {
    val listFilter = repositories
        .asSequence()
        .filter { it.description.contains("A") }
        .map { it.stargazers_count * it.forks_count }
        .toList()

    for (i in listFilter.indices) {
        repositories[i].open_issues = listFilter[i]
    }
    notifyDataSetChanged()
}

fun RepositoryAdapter.filterFind() {
    repositories.find { it.full_name == "E" }
}

fun RepositoryAdapter.filterAny() {
    repositories.any { it.name == "Alison" }
}

fun RepositoryAdapter.filterAll() {
    repositories.all { it.name == "Alison" }
}

fun RepositoryAdapter.filterIncrement() {
    repositories
        .filter { it.stargazers_count > 500 }
        .count()
}

fun RepositoryAdapter.filterDecrement() {
    repositories
        .asSequence()
        .map { it.stargazers_count * 5 }
        .map { it.dec() }
        .toList()
    notifyDataSetChanged()
}