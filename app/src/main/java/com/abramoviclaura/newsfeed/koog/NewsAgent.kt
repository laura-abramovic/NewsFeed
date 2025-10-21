package com.abramoviclaura.newsfeed.koog

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import com.abramoviclaura.newsfeed.data.NewsList
import com.abramoviclaura.newsfeed.domain.NewsSection
import com.abramoviclaura.newsfeed.domain.NewsType
import com.abramoviclaura.newsfeed.prompts.croatiaNewsPrompt
import com.abramoviclaura.newsfeed.prompts.techNewsPrompt
import com.abramoviclaura.newsfeed.prompts.worldNewsPrompt
import kotlinx.serialization.json.Json

interface NewsAgent {
    suspend fun fetchNews(): List<NewsSection>
}

class NewsAgentImpl() : NewsAgent {

    val apiKey = "" // your API key here

    val client = OpenAILLMClient(apiKey)
    val prompts = listOf(worldNewsPrompt, croatiaNewsPrompt, techNewsPrompt)

    override suspend fun fetchNews(): List<NewsSection> =
        prompts.mapIndexed { index, prompt ->
            val response = client.execute(
                prompt = prompt,
                model = OpenAIModels.Chat.GPT4o
            )

            val responseContent = response.firstOrNull()?.content
            val news = responseContent?.let { Json.decodeFromString<NewsList>(responseContent) }
                ?: NewsList(emptyList())

            NewsSection(
                type = NewsType.entries[index],
                news = news.news
            )
        }
}
