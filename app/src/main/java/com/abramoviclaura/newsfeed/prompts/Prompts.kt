package com.abramoviclaura.newsfeed.prompts

import ai.koog.prompt.dsl.prompt

private val SYSTEM_MESSAGE = """
   You are a professional news summarizer. Your task is to provide concise, accurate, and clear summaries of current news.
    Output the result in JSON format like this:
    {
        "news": [
            "Bullet point 1",
            "Bullet point 2",
            "Bullet point 3"
        ]
    }. Do not write anything else in the response.
""".trimIndent()

private fun userPrompt(topic: String, sources: List<String>): String {
    val sourcesString = sources.joinToString(", ")
    val text = """
        Provide a concise summary of today’s $topic news in 5–10 bullet points. Use $sourcesString as primary sources. Do not copy headlines—read each article and extract the key facts. Keep bullets short, clear, and straight to the point, focusing only on the main events and developments."
    """.trimIndent()
    return text
}

val worldNewsPrompt = prompt("WorldNewsPrompt") {
    system(SYSTEM_MESSAGE)
    user(userPrompt("world", listOf("BBC", "Reuters", "New York Times")))
}

val croatiaNewsPrompt = prompt("CroatiaNewsPrompt") {
    system(SYSTEM_MESSAGE)
    user(userPrompt("Croatia", listOf("Telegram.hr", "Večernji List")))
}

val techNewsPrompt = prompt("TechNewsPrompt") {
    system(SYSTEM_MESSAGE)
    user(userPrompt("tech industry", listOf("The Verge", "Wired", "Reuters Technology")))
}
