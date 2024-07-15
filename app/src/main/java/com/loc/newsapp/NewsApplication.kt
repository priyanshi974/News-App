package com.loc.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/***
 * Giving Hilt the access to our Application. Hilt will inject the application from here.
 */
@HiltAndroidApp
class NewsApplication : Application() {
}