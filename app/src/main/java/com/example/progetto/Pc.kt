package com.example.progetto

import android.os.Parcel
import android.os.Parcelable

data class Pc(val image:Int, val name:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel!!.writeInt(image)
        parcel.writeString(name)
    }

    companion object CREATOR : Parcelable.Creator<Pc> {
        override fun createFromParcel(parcel: Parcel): Pc {
            return Pc(parcel)
        }

        override fun newArray(size: Int): Array<Pc?> {
            return arrayOfNulls(size)
        }
    }
}