package com.example.popularmovies.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.popularmovies.R
import com.example.popularmovies.deps.AppDependenciesProvider

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as AppDependenciesProvider).provideAppDependencies().inject(this)
        setContentView(R.layout.activity_main)
    }
}
