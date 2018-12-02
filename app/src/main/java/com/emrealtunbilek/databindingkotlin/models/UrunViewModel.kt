package com.emrealtunbilek.databindingkotlin.models

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class UrunViewModel(urun: Urun, miktar:Int) : BaseObservable() {

    @get:Bindable
    var urun:Urun = urun
    set(value) {
        field = value
        notifyPropertyChanged(BR.urun)
    }

    @get:Bindable
    var miktar:Int = miktar
    set(value) {
        field = value
        notifyPropertyChanged(BR.miktar)
    }

    @get:Bindable
    var resimYuklendi : Boolean = false
    set(value) {
        field = value
        notifyPropertyChanged(BR.resimYuklendi)
    }

    fun miktariDegis(){
        miktar = 5

        Log.e("EEE","MİKTAR DEĞİŞTİRİLDİ")
    }


}