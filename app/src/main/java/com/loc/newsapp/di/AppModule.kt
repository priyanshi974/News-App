package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.data.manager.LocalUserManagerImp
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.manager.usecases.app_entry.AppEntryUseCases
import com.loc.newsapp.domain.manager.usecases.app_entry.ReadAppEntry
import com.loc.newsapp.domain.manager.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}
