package com.loc.newsapp.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source
import com.loc.newsapp.presentation.details.DetailsEvent
import com.loc.newsapp.presentation.details.DetailsScreen
import com.loc.newsapp.presentation.details.DetailsViewModel
import com.loc.newsapp.presentation.home.HomeScreen
import com.loc.newsapp.presentation.home.HomeViewModel
import com.loc.newsapp.presentation.onboarding.OnboardingScreen
import com.loc.newsapp.presentation.onboarding.OnboardingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

fun getArticle(): Article {
    return Article(
        author = "",
        title = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
        description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
        content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
        publishedAt = "2023-06-16T22:24:33Z",
        source = Source(
            id = "", name = "bbc"
        ),
        url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
        urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
    )
}

@Composable
fun NavGraph (
    startDestination: String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.OnboardingScreen.route) {

        composable(route = Route.OnboardingScreen.route) {
            val viewModel: OnboardingViewModel = hiltViewModel()
            OnboardingScreen(event = {
                viewModel.onEvent(it)
                navController.navigate(Route.NewsNavigationScreen.route)
                // event = viewModel::onEvent
            })
        }

        composable(route = Route.NewsNavigationScreen.route) {
            val viewModel : HomeViewModel = hiltViewModel()
            val articles: LazyPagingItems<Article> = viewModel.news.collectAsLazyPagingItems()
            HomeScreen(articles = articles, navigateToSearch = {}, navigateToDetails = {
                navController.navigate(Route.DetailsScreen.route)
            })
        }

        composable(route = Route.DetailsScreen.route) {
            val viewModel : DetailsViewModel = hiltViewModel()
            val article : Article = getArticle()
            DetailsScreen(article = article, event = {
                viewModel.onEvent(it) },
                navigateUp = {
                    navController.navigateUp()
                })
        }

//        // navigation block 1
//        navigation(
//            route = Route.AppStartNavigation.route,
//            startDestination = Route.OnboardingScreen.route
//        ) {
//            composable(route = Route.OnboardingScreen.route) {
//                val viewModel: OnboardingViewModel = hiltViewModel()
//                OnboardingScreen(event = {
//                    viewModel.onEvent(it)
//                    // event = viewModel::onEvent
//                })
//            }
//        }

//        // navigation block 2
//        navigation(
//            route = Route.NewsNavigation.route,
//            startDestination = Route.NewsNavigationScreen.route
//        ) {
//            composable(route = Route.NewsNavigationScreen.route) {
//                val viewModel : HomeViewModel = hiltViewModel()
//                val articles: LazyPagingItems<Article> = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(articles = articles, navigateToSearch = {}, navigateToDetails = {})
//            }
//        }
//
//        // navigation block 3
//        navigation(
//            route = Route.NewsNavigationScreen.route,
//            startDestination = Route.DetailsScreen.route
//        ) {
//            composable(route = Route.DetailsScreen.route) {
//                val viewModel : DetailsViewModel = hiltViewModel()
//                val article : Article = getArticle()
//                DetailsScreen(article = article, event = {
//                    viewModel.onEvent(it) },
//                    navigateUp = {})
//            }
//        }
    }
}
