package com.ahmadi.mokhtar.immenseharbor.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
class LoginResponse (
    val id_token:String
):Parcelable