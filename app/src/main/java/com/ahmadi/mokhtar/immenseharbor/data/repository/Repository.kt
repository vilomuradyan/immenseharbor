package com.ahmadi.mokhtar.immenseharbor.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.ahmadi.mokhtar.immenseharbor.data.database.AppDatabase
import com.ahmadi.mokhtar.immenseharbor.data.models.Department
import com.ahmadi.mokhtar.immenseharbor.data.models.Login
import com.ahmadi.mokhtar.immenseharbor.data.models.LoginResponse
import com.ahmadi.mokhtar.immenseharbor.data.prefrence.PreferenceHelper
import com.ahmadi.mokhtar.immenseharbor.data.remote.Api
import com.ahmadi.mokhtar.immenseharbor.utils.AppConstants
import com.ahmadi.mokhtar.immenseharbor.utils.isNetworkConnected
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class Repository @Inject constructor(private val context: Context, private val dataBase: AppDatabase, private val api: Api,
                                     private val preferenceHelper: PreferenceHelper) : RepositoryHelper {

    override fun registered(): Single<Int> = Single.just(preferenceHelper.getCurrentUserLoggedInMode())


    override fun login(userName: String, password: String): Observable<LoginResponse> {
        return api.login(Login(userName,password,true)).doOnNext {
            preferenceHelper.setCurrentUserToken(it.id_token)
            preferenceHelper.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
        }
    }


    override fun departments(): Observable<List<Department>> {
        var hasConnection  = isNetworkConnected(context)
        var observableFromApi: Observable<List<Department>>? = null
        if (hasConnection) {
            observableFromApi = getDepartmentFromApi()
        }

        var observableFromDb = getDepartmentFromDb()

        return if (hasConnection) Observable.concatArrayEager(observableFromApi,observableFromDb )
        else observableFromDb
    }


    private fun getDepartmentFromApi(): Observable<List<Department>> {
        return api.departments("Bearer ${preferenceHelper.getCurrentUserToken()}").doOnNext {

            for (item in it!!) {
                item?.apply {
                    dataBase.departmentDao.insert(item)
                }
            }
        }
    }

    private fun getDepartmentFromDb(): Observable<List<Department>>{
        return dataBase.departmentDao.result().toObservable()
    }

}