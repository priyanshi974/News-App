package com.loc.newsapp.presentation.onboarding

/***
 * Sealed classes are used to restrict the users from inheriting the class
 * This class will have the events sent from UI to the viewModel
 */
sealed class OnboardingEvent {

    object SaveAppEntry: OnboardingEvent()
}
