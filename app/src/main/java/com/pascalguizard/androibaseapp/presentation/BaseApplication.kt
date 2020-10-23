package com.pascalguizard.androibaseapp.presentation

import android.app.Application
import com.pascalguizard.androibaseapp.presentation.core.graph.apiModule
import com.pascalguizard.androibaseapp.presentation.core.graph.appModule
import com.pascalguizard.androibaseapp.presentation.core.graph.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by lmiyagi on 11/8/17.
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(appModule, apiModule, mainModule))
        }
    }
}