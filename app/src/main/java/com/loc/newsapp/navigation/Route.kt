package com.loc.newsapp.navigation

sealed class Route(
    val route: String
) {
    object OnboardingScreen: Route("onboardingScreen")
    object HomeScreen: Route("homeScreen")
    object DetailsScreen: Route("detailsScreen")

    //subNavigation
    object AppStartNavigation: Route("appStartNavigation") // for onboarding screen
    object NewsNavigation: Route("newsNavigation") // for home screen
    object NewsNavigationScreen: Route("newsNavigationScreen") // for details screen
}