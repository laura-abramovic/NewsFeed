package com.abramoviclaura.newsfeed.domain

sealed class NewsViewState {
    data class News(val sections: List<NewsSection>) : NewsViewState()
    data object Empty : NewsViewState()
    data object Loading : NewsViewState()
    data object Error : NewsViewState()
}

enum class NewsType {
    GLOBAL, LOCAL, TECH
}

data class NewsSection(
    val type: NewsType,
    val news: List<String>
)
