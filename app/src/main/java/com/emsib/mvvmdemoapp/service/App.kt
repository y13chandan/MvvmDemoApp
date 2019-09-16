package com.emsib.mvvmdemoapp.service

import android.app.Application
import com.emsib.mvvmdemoapp.network.ApiCalls
import com.emsib.mvvmdemoapp.network.NetworkConnectionInterceptor
import com.emsib.mvvmdemoapp.repository.HomeRepository
import com.emsib.mvvmdemoapp.screen.home.HomeViewModelFactory
import com.google.gson.Gson
import org.kodein.di.Kodein.Companion.lazy
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App: Application(), KodeinAware {
    override val kodein = lazy {
        import(androidXModule(this@App))

        bind() from singleton { Gson() }
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiCalls(instance()) }
        bind() from singleton { HomeRepository(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
    }
}