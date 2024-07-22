package com.loc.newsapp.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.manager.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel(){

    var state = mutableStateOf(HomeState())
        private set

    val news = newsUseCases.getNews(
        source = listOf("aaj-tak","abp-news","ndtv-india","bbc-news","abc-news")
    ).cachedIn(viewModelScope)
}