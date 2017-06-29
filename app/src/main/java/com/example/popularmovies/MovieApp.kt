package com.example.popularmovies

import android.support.multidex.MultiDexApplication

import com.example.popularmovies.common.AppModule
import com.example.popularmovies.deps.AppDependencies
import com.example.popularmovies.deps.AppDependenciesProvider
import com.example.popularmovies.deps.DaggerAppDependencies

/**
 * Created by rezagama on 6/29/17.
 */

class MovieApp : MultiDexApplication(), AppDependenciesProvider {
    lateinit var dependencies: AppDependencies

    override fun onCreate() {
        super.onCreate()
        dependencies = DaggerAppDependencies.builder().appModule(AppModule(this)).build()
    }

    override fun provideAppDependencies(): AppDependencies {
        return dependencies
    }
}
