package com.calvinnor.dontkeepactivitiesgame.data

import android.os.Parcel
import android.os.Parcelable

data class GameState(
    val playerOneDetails: PlayerDetails,
    val playerTwoDetails: PlayerDetails,
    var playerOneScore: Long,
    var playerTwoScore: Long
) : Parcelable {

    constructor(parcel: Parcel) : this(
        playerOneDetails = parcel.readParcelable(PlayerDetails::class.java.classLoader),
        playerTwoDetails = parcel.readParcelable(PlayerDetails::class.java.classLoader),
        playerOneScore = parcel.readLong(),
        playerTwoScore = parcel.readLong()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(playerOneDetails, flags)
        parcel.writeParcelable(playerTwoDetails, flags)
        parcel.writeLong(playerOneScore)
        parcel.writeLong(playerTwoScore)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameState> {
        override fun createFromParcel(parcel: Parcel): GameState {
            return GameState(parcel)
        }

        override fun newArray(size: Int): Array<GameState?> {
            return arrayOfNulls(size)
        }
    }
}
