package com.abramoviclaura.newsfeed.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abramoviclaura.newsfeed.ui.theme.Dimens
import com.abramoviclaura.newsfeed.ui.theme.NewsFeedTheme

@Composable
fun NewsSection(
    title: String,
    news: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.headlineSmall,
        )

        Spacer(Modifier.height(Dimens.m))

        news.forEach { item ->
            Row {
                Box(
                    Modifier
                        .padding(top = Dimens.bulletPointPaddingTop)
                        .size(Dimens.s)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onPrimaryContainer)
                )

                Spacer(Modifier.width(12.dp))

                Text(
                    text = item,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(Modifier.height(Dimens.s))
        }
    }
}

@Preview
@Composable
private fun NewsSectionPreview() = NewsFeedTheme {
    NewsSection(
        title = "Tech news",
        news = listOf(
            "Apple introduces new MacBook Pro models with M3 chips featuring improved performance and energy efficiency.",
            "Meta unveils updates to its AI-driven advertising tools aimed at enhancing targeting accuracy and effectiveness.",
            "Google launches a beta version of a quantum computing service, focusing on research collaboration and increased accessibility.",
            "Samsung announces expansion of its semiconductor fabrication plant in Texas, with a significant investment plan over the next decade.",
            "Amazon suffers a major service outage affecting multiple regions, causing disruptions in AWS-dependent services.",
            "Nvidia's latest AI hardware gains traction in data centers, pushing the company towards record-breaking sales in Q3.",
            "SpaceX successfully launches its fifth crewed mission to the International Space Station, marking continued progress in commercial space flights."
        )
    )
}
