package com.ahmadi.mokhtar.immenseharbor

import android.app.Application
import com.ahmadi.mokhtar.immenseharbor.di.component.DIComponent
import com.ahmadi.mokhtar.immenseharbor.di.component.DaggerDIComponent
import com.ahmadi.mokhtar.immenseharbor.di.modules.ApiModule
import com.ahmadi.mokhtar.immenseharbor.di.modules.AppModule

class App : Application() {

    lateinit var di : DIComponent
    override fun onCreate() {
        super.onCreate()

        di = DaggerDIComponent
            .builder()
            .apiModule(ApiModule())
            .appModule(AppModule(this))
            .build()
    }
}