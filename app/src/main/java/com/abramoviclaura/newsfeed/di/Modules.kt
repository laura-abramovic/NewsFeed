package com.abramoviclaura.newsfeed.di

import com.abramoviclaura.newsfeed.domain.NewsViewModel
import com.abramoviclaura.newsfeed.koog.NewsAgent
import com.abramoviclaura.newsfeed.koog.NewsAgentImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NewsViewModel(newsAgent = get()) }
}

val agentModule = module {
    single<NewsAgent> { NewsAgentImpl() }
}
