package com.ahmadi.mokhtar.immenseharbor.data.prefrence

import com.ahmadi.mokhtar.immenseharbor.utils.AppConstants

interface PreferenceHelper {
    fun getCurrentUserToken():String?
    fun setCurrentUserToken(token :String)
    fun getCurrentUserLoggedInMode(): Int
    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)
}