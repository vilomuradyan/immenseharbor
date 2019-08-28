package com.ahmadi.mokhtar.immenseharbor.di.component

import androidx.annotation.Keep
import com.ahmadi.mokhtar.immenseharbor.di.modules.ApiModule
import com.ahmadi.mokhtar.immenseharbor.di.modules.AppModule
import com.ahmadi.mokhtar.immenseharbor.view.activities.MainActivity
import com.ahmadi.mokhtar.immenseharbor.viewModel.LoginViewModel
import com.ahmadi.mokhtar.immenseharbor.viewModel.MainViewModel
import com.ahmadi.mokhtar.immenseharbor.viewModel.SplashViewModel
import dagger.Component
import javax.inject.Singleton

@Keep
@Singleton
@Component(modules = [AppModule::class , ApiModule::class])
interface DIComponent {

    interface Injectable{
        fun inject(diComponent: DIComponent)
    }

    fun inject(mainViewModel: MainViewModel)
    fun inject(loginViewModel: LoginViewModel)
    fun inject(splashViewModel: SplashViewModel)

}