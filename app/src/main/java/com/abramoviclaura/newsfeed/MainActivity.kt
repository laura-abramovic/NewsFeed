package com.abramoviclaura.newsfeed

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.newsfeed.data.NewsList
import com.abramoviclaura.newsfeed.prompts.croatiaNewsPrompt
import com.abramoviclaura.newsfeed.prompts.techNewsPrompt
import com.abramoviclaura.newsfeed.prompts.worldNewsPrompt
import com.abramoviclaura.newsfeed.ui.theme.NewsFeedTheme
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsFeedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsFeedTheme {
        Greeting("Android")
    }
}

fun main() {
    runBlocking {
        val apiKey = System.getenv("OPENAI_API_KEY") ?: return@runBlocking

        val client = OpenAILLMClient(apiKey)

        val prompts = listOf(worldNewsPrompt, croatiaNewsPrompt, techNewsPrompt)

        prompts.forEach { prompt ->
            val response = client.execute(
                prompt = prompt,
                model = OpenAIModels.Chat.GPT4o
            )

            val responseContent = response.firstOrNull()?.content ?: return@forEach
            val news = Json.decodeFromString<NewsList>(responseContent)

            println(news)
        }
    }
}

