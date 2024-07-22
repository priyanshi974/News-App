package com.loc.newsapp.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.loc.newsapp.presentation.navigation.NavGraph
import com.loc.newsapp.presentation.navigation.Route
import com.loc.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier


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

//        CoroutineScope(Dispatchers.IO +
//                Job() +
//                CoroutineName("") +
//                CoroutineExceptionHandler { coroutineContext, throwable ->
//
//                }).launch {  }
//        lifecycleScope.launch
//            appEntryUseCases.readAppEntry().collect{
//                Log.d("test", it.toString())
//            }

        setContent {
            NewsAppTheme(dynamicColor = false) {
//                val systemUiColor = rememberSystemUiController()
//                SideEffect {
//                    systemUiColor.setSystemBarsColor(
//                        color = Color.Transparent,
//                        darkIcons = !isSystemInDarkMode
//                    )
//                }
//                //Add fillMaxSize()
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
