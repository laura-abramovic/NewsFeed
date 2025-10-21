package com.abramoviclaura.newsfeed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abramoviclaura.newsfeed.screen.NewsScreen
import com.abramoviclaura.newsfeed.ui.theme.NewsFeedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsFeedTheme {
                NewsScreen()
            }
        }
    }
}
