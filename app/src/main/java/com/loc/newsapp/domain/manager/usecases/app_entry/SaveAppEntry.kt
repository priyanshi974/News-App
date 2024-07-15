package com.loc.newsapp.domain.manager.usecases.app_entry

import com.loc.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}