package com.ahmadi.mokhtar.immenseharbor.data.remote

import com.ahmadi.mokhtar.immenseharbor.data.models.Department
import com.ahmadi.mokhtar.immenseharbor.data.models.Login
import com.ahmadi.mokhtar.immenseharbor.data.models.LoginResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface Api {

    @POST("authenticate")
    fun login(@Body login: Login):Observable<LoginResponse>

    @GET("departments")
    fun departments(@Header("Authorization") authorization : String):Observable<List<Department>>
}