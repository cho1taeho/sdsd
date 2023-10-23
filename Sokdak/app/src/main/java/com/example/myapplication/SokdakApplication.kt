package com.example.myapplication

import android.app.Application
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager

import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class AirbankApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}