package com.loc.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.loc.newsapp.navigation.NavGraph
import com.loc.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    @Inject
//    lateinit var appEntryUseCases: AppEntryUseCases
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
        }

        CoroutineScope(Dispatchers.IO +
                Job() +
                CoroutineName("") +
                CoroutineExceptionHandler { coroutineContext, throwable ->

                }).launch {  }
//        lifecycleScope.launch
//            appEntryUseCases.readAppEntry().collect{
//                Log.d("test", it.toString())
//            }
//        }

        setContent {
            NewsAppTheme {
                val startDestination = viewModel.startDestination
                NavGraph(startDestination = startDestination.value)
            }
        }
    }
}
