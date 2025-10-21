package com.abramoviclaura.newsfeed.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abramoviclaura.newsfeed.R
import com.abramoviclaura.newsfeed.domain.NewsViewModel
import com.abramoviclaura.newsfeed.domain.NewsViewState
import com.abramoviclaura.newsfeed.screen.components.EmptySection
import com.abramoviclaura.newsfeed.screen.components.ErrorSection
import com.abramoviclaura.newsfeed.screen.components.NewsList
import com.abramoviclaura.newsfeed.ui.theme.Dimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsScreen(viewModel: NewsViewModel = koinViewModel()) {

    val viewState = viewModel.newsViewState().collectAsStateWithLifecycle(NewsViewState.Empty).value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = Dimens.m)
    ) {
        when (val state = viewState) {
            NewsViewState.Empty -> EmptySection(viewModel::onGenerateButtonClick)
            NewsViewState.Error -> ErrorSection(viewModel::onGenerateButtonClick)
            NewsViewState.Loading -> CircularProgressIndicator(modifier = Modifier.size(Dimens.loadingIndicatorSize))
            is NewsViewState.News -> NewsList(viewState = state)
        }
    }
}

@Composable
fun GenerateNewsButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) = Button(
    onClick = onClick,
    modifier = modifier
) {
    Text(
        stringResource(R.string.generate_news),
        style = MaterialTheme.typography.bodyLarge
    )
}
