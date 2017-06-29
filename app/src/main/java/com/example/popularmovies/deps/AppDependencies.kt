package com.example.popularmovies.deps

import com.example.popularmovies.home.HomeActivity
import com.example.popularmovies.common.AppModule
import com.example.popularmovies.network.ConfigModule
import com.example.popularmovies.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by rezagama on 6/29/17.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ConfigModule::class,
        NetworkModule::class
    ))

interface AppDependencies {
    fun inject(homeActivity: HomeActivity)
}
