package com.example.popularmovies.network

import dagger.Module
import javax.inject.Singleton

import dagger.Provides

/**
 * Created by rezagama on 6/29/17.
 */

@Module
class ConfigModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun provideNetworkConfig(): NetworkConfig {
        return NetworkConfig(baseUrl)
    }
}
