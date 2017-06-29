package com.example.popularmovies.network

import android.content.Context

import com.example.popularmovies.R

import java.io.IOException

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by rezagama on 6/29/17.
 */

class AppRequestInterceptor(private val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY, context.getString(R.string.movie_api_key))
                .build()

        val requestBuilder = original.newBuilder()
                .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }

    companion object {
        private val API_KEY = "api_key"
    }
}
