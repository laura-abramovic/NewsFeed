package com.abramoviclaura.newsfeed.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abramoviclaura.newsfeed.koog.NewsAgent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class NewsViewModel(private val newsAgent: NewsAgent) : ViewModel() {

    private val newsPublisher = MutableStateFlow<List<NewsSection>>(emptyList())
    private val loadingPublisher = MutableStateFlow(false)

    fun newsViewState(): Flow<NewsViewState> =
        combine(
            newsPublisher,
            loadingPublisher
        ) { news, loading ->
            when {
                loading -> NewsViewState.Loading
                news.isEmpty() -> NewsViewState.Empty
                else -> NewsViewState.News(news)
            }
        }

    fun onGenerateButtonClick() {
        viewModelScope.launch {
            loadingPublisher.value = true
            val news = newsAgent.fetchNews()
            newsPublisher.value = news
            loadingPublisher.value = false
        }
    }
}
