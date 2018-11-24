package com.emrealtunbilek.databindingkotlin.models

import android.os.Parcel
import android.os.Parcelable

class Urun(
    val baslik: String, val aciklama: String,
    val urunResim: Int, val fiyat: Double,
    val kampanyaliFiyat: Double, val degerlendirmeSayisi: Int,
    val degerlendirmeNotu: Float, val seriNumarasi: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(baslik)
        parcel.writeString(aciklama)
        parcel.writeInt(urunResim)
        parcel.writeDouble(fiyat)
        parcel.writeDouble(kampanyaliFiyat)
        parcel.writeInt(degerlendirmeSayisi)
        parcel.writeFloat(degerlendirmeNotu)
        parcel.writeInt(seriNumarasi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Urun> {
        override fun createFromParcel(parcel: Parcel): Urun {
            return Urun(parcel)
        }

        override fun newArray(size: Int): Array<Urun?> {
            return arrayOfNulls(size)
        }
    }


}