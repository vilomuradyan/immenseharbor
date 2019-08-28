package com.ahmadi.mokhtar.immenseharbor.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmadi.mokhtar.immenseharbor.data.models.Department
import com.ahmadi.mokhtar.immenseharbor.data.repository.RepositoryHelper
import com.ahmadi.mokhtar.immenseharbor.di.component.DIComponent
import com.ahmadi.mokhtar.immenseharbor.utils.iomain
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashViewModel:ViewModel(),DIComponent.Injectable {

    var registerResult: MutableLiveData<Int> = MutableLiveData()
    var compositeDisposable = CompositeDisposable();

    @Inject
    lateinit var repositoryHelper: RepositoryHelper

    override fun inject(diComponent: DIComponent) {
        diComponent.inject(this)
    }

    fun registered(){
        compositeDisposable.add(repositoryHelper.registered().iomain().subscribe({
            registerResult.postValue(it)
        },{

        }))
    }

    fun dispose(){
        compositeDisposable.clear()
    }
}