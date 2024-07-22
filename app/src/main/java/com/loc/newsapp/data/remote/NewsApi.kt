package com.loc.newsapp.data.remote

import com.loc.newsapp.data.remote.dto.NewsResponse
import com.loc.newsapp.utils.constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

// Retrofit API
interface NewsApi {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}