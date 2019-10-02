package com.calvinnor.dontkeepactivitiesgame.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerDetails(
    val id: Int,
    val name: String
) : Parcelable
