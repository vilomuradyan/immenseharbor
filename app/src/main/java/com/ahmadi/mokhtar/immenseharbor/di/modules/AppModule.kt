package com.ahmadi.mokhtar.immenseharbor.di.modules

import android.content.Context
import androidx.room.Room
import com.ahmadi.mokhtar.immenseharbor.App
import com.ahmadi.mokhtar.immenseharbor.data.database.AppDatabase
import com.ahmadi.mokhtar.immenseharbor.data.prefrence.AppPreferenceHelper
import com.ahmadi.mokhtar.immenseharbor.data.prefrence.PreferenceHelper
import com.ahmadi.mokhtar.immenseharbor.data.remote.Api
import com.ahmadi.mokhtar.immenseharbor.data.repository.Repository
import com.ahmadi.mokhtar.immenseharbor.data.repository.RepositoryHelper
import com.ahmadi.mokhtar.immenseharbor.di.annotations.PreferenceInfo
import com.ahmadi.mokhtar.immenseharbor.utils.AppConstants
import com.ahmadi.mokhtar.immenseharbor.utils.AppConstants.PREF_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    fun providesApp(): App = app

    @Provides
    @Singleton
    internal fun provideContext(): Context =app.applicationContext


    @Singleton
    @Provides
    internal fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME).build()
    }



    @Singleton
    @Provides
    internal fun providesRepositoryHelper(repository: Repository):RepositoryHelper  = repository

    @Provides
    @PreferenceInfo
    internal fun providesPrefFileName(): String = PREF_NAME


    @Provides
    @Singleton
    internal fun providesPrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper
}