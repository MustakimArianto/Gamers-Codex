package com.mustakimarianto.gamerscodex

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GamersCodexApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Prevent app to use dark mode
        preventDarkMode()
    }

    /**
     * Prevent app to use dark mode.
     */
    private fun preventDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}