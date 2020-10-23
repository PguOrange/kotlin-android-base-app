package com.pascalguizard.androibaseapp.presentation.core.graph

import com.pascalguizard.androibaseapp.data.api.ApiClient
import com.pascalguizard.androibaseapp.data.api.ApiService
import com.pascalguizard.androibaseapp.data.repository.DefaultRepository
import com.pascalguizard.androibaseapp.domain.main.GetErrorExample
import com.pascalguizard.androibaseapp.domain.main.GetMainMessage
import com.pascalguizard.androibaseapp.domain.repository.Repository
import com.pascalguizard.androibaseapp.presentation.main.MainActivity
import com.pascalguizard.androibaseapp.presentation.main.MainViewModel
import com.pascalguizard.androibaseapp.presentation.utils.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by lmiyagi on 11/8/17.
 */
val appModule = module {

    single<Repository> { DefaultRepository(get()) }
}

val apiModule = module {

    single(named(D_API_BASE_URL)) {
        if (BuildConfig.BUILD_TYPE.equals(DEBUG, true) ||
                BuildConfig.BUILD_TYPE.equals(STAGING, true)) {
            API_BASE_STAGING_URL
        } else {
            API_BASE_URL
        }
    }

    single<Interceptor>(named(D_LOGGING_INTERCEPTOR)) {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single {
        OkHttpClient.Builder()
                .addNetworkInterceptor(get<Interceptor>(named(D_LOGGING_INTERCEPTOR)))
                .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
                .baseUrl(get<String>(named(D_API_BASE_URL)))
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    single { ApiClient(get()) }
}

val mainModule = module {

    scope(named<MainActivity>()) {
        scoped { GetMainMessage(get()) }
        scoped { GetErrorExample(get()) }
        viewModel { MainViewModel(get(), get()) }
    }
}