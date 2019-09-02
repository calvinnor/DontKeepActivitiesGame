package com.calvinnor.dontkeepactivitiesgame.data

import android.os.Parcel
import android.os.Parcelable

data class PlayerDetails(
    val id: Int,
    val name: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString() as String
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlayerDetails> {

        override fun createFromParcel(parcel: Parcel): PlayerDetails {
            return PlayerDetails(parcel)
        }

        override fun newArray(size: Int): Array<PlayerDetails?> {
            return arrayOfNulls(size)
        }
    }
}
