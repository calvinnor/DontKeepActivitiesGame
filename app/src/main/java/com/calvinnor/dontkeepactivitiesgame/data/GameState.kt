package com.calvinnor.dontkeepactivitiesgame.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameState(
    val playerOneDetails: PlayerDetails,
    val playerTwoDetails: PlayerDetails,
    var playerOneScore: Long,
    var playerTwoScore: Long
) : Parcelable
