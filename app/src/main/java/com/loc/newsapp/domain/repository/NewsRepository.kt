package com.loc.newsapp.domain.repository

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

/***
 * This repository provides a surface to fetch data source as input and
 * outputs a flow of Paging Data, which is further taken by HomeViewModel.
 */
interface NewsRepository {

    fun getNews(source: List<String>) : Flow<PagingData<Article>>
}