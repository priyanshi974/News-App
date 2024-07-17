package com.loc.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.loc.newsapp.data.remote.NewsApi
import com.loc.newsapp.data.remote.NewsPagingSource
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, source = source.joinToString(separator = ","))
            }
        ).flow
    }
}