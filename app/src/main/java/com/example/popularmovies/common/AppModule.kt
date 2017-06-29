package com.example.popularmovies.common

import android.content.Context
import dagger.Module

import javax.inject.Singleton

import dagger.Provides

/**
 * Created by rezagama on 6/29/17.
 */

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return this.context
    }
}
