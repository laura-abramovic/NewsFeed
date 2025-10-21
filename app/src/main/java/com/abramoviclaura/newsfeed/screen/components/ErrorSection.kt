package com.abramoviclaura.newsfeed.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.newsfeed.R
import com.abramoviclaura.newsfeed.screen.GenerateNewsButton
import com.abramoviclaura.newsfeed.ui.theme.Dimens
import com.abramoviclaura.newsfeed.ui.theme.NewsFeedTheme

@Composable
fun ErrorSection(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
) {
    Text(
        text = stringResource(R.string.error_screen_message),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        style = MaterialTheme.typography.titleMedium,
    )

    Spacer(Modifier.height(Dimens.xl))

    GenerateNewsButton(onClick = onButtonClick)
}

@Preview
@Composable
private fun ErrorSectionPreview() = NewsFeedTheme {
    ErrorSection({})
}
