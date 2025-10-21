package com.abramoviclaura.newsfeed

import android.app.Application
import com.abramoviclaura.newsfeed.di.agentModule
import com.abramoviclaura.newsfeed.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsFeedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            androidLogger()
            androidContext(this@NewsFeedApplication)
            modules(viewModelModule, agentModule)
        }
    }
}
