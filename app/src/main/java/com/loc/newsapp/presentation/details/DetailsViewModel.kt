package com.loc.newsapp.presentation.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.manager.usecases.news.NewsUseCases
import com.loc.newsapp.presentation.home.HomeState
import com.loc.newsapp.presentation.onboarding.OnboardingEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

//    var state = mutableStateOf(HomeState())
//        private set
//
//    val news = newsUseCases.getNews(
//        source = listOf("aaj-tak","abp-news","ndtv-india","bbc-news","abc-news")
//    ).cachedIn(viewModelScope)

    fun onEvent(event: DetailsEvent){
        when(event){
            is DetailsEvent.ShowDes ->{
                showNewsEntry()
            }

            DetailsEvent.SaveArticle -> TODO()
        }
    }

    private fun showNewsEntry() {
        // This scope will be canceled when ViewModel.onCleared is called.
        viewModelScope.launch {
            newsUseCases.getNews
        }
    }
}