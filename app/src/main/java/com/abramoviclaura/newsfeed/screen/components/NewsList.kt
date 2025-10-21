package com.abramoviclaura.newsfeed.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.newsfeed.R
import com.abramoviclaura.newsfeed.domain.NewsSection
import com.abramoviclaura.newsfeed.domain.NewsType
import com.abramoviclaura.newsfeed.domain.NewsViewState
import com.abramoviclaura.newsfeed.ui.theme.Dimens
import com.abramoviclaura.newsfeed.ui.theme.NewsFeedTheme

@Composable
fun NewsList(
    viewState: NewsViewState.News,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.padding(Dimens.m))

        viewState.sections.forEachIndexed { index, section ->
            NewsSection(
                title = section.type.toTitle(),
                news = section.news
            )

            if (index != viewState.sections.lastIndex) {
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = Dimens.m)
                )
            }
        }

        Spacer(Modifier.padding(Dimens.m))
    }
}

@ReadOnlyComposable
@Composable
private fun NewsType.toTitle() = when (this) {
    NewsType.GLOBAL -> stringResource(R.string.world_news)
    NewsType.LOCAL -> stringResource(R.string.croatia_news)
    NewsType.TECH -> stringResource(R.string.tech_news)
}

@Preview
@Composable
private fun NewsListPreview() = NewsFeedTheme {
    NewsList(
        NewsViewState.News(
            listOf(
                NewsSection(
                    NewsType.GLOBAL,
                    listOf("News 1", "News 2", "News 3", "News 4", "News 5")
                ),
                NewsSection(
                    NewsType.LOCAL,
                    listOf("News 1", "News 2", "News 3", "News 4", "News 5")
                ),
                NewsSection(
                    NewsType.TECH,
                    listOf("News 1", "News 2", "News 3", "News 4", "News 5")
                ),
            )
        )
    )
}
