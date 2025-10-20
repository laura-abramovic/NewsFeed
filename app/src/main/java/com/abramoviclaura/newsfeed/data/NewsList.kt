package com.abramoviclaura.newsfeed.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsList(
    @SerialName("news") val news: List<String>
)
