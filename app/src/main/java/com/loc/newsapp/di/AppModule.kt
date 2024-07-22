package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.data.manager.LocalUserManagerImp
import com.loc.newsapp.data.remote.NewsApi
import com.loc.newsapp.data.repository.NewsRepositoryImp
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.manager.usecases.app_entry.AppEntryUseCases
import com.loc.newsapp.domain.manager.usecases.app_entry.ReadAppEntry
import com.loc.newsapp.domain.manager.usecases.app_entry.SaveAppEntry
import com.loc.newsapp.domain.manager.usecases.news.GetNews
import com.loc.newsapp.domain.manager.usecases.news.NewsUseCases
import com.loc.newsapp.domain.repository.NewsRepository
import com.loc.newsapp.utils.constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// This means instance will be created only once throughout one application run
object AppModule {

    // providing Local user manager here which requires Context as an Input
    // we provide context using application
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImp(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsRepositoryImp(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ) = NewsUseCases(
        getNews = GetNews(newsRepository)
    )
}
