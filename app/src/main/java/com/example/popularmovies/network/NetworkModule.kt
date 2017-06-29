package com.example.popularmovies.network

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.DateTypeAdapter
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

/**
 * Created by rezagama on 6/29/17.
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRequestInterceptor(context: Context) : AppRequestInterceptor {
        return AppRequestInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .registerTypeAdapter(Date::class.java, DateTypeAdapter()).create()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: AppRequestInterceptor) : OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(networkConfig: NetworkConfig, httpClient: OkHttpClient, gson: Gson) : Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .baseUrl(networkConfig.baseUrl)
                .build()
    }

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit) : NetworkService {
        return retrofit.create(NetworkService::class.java)
    }
}