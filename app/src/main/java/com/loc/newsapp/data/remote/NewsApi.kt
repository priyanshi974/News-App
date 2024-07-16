package com.loc.newsapp.data.remote

import retrofit2.http.GET

// Retrofit API
interface NewsApi {

    @GET("everything")
    suspend fun getNews(){

    }
}