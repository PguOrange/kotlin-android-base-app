package br.com.leonardomiyagi.kotlinbaseapplication.presentation.core.providers

import br.com.leonardomiyagi.kotlinbaseapplication.domain.provider.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DefaultSchedulerProvider @Inject constructor() : SchedulerProvider {

    override fun io(): Scheduler = Schedulers.io()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}