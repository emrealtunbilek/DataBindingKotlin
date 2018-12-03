package com.emrealtunbilek.databindingkotlin.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.emrealtunbilek.databindingkotlin.BR

class SepetViewModel : BaseObservable() {

    @get:Bindable
    var sepettekiUrunler:ArrayList<SepetUrun> = ArrayList<SepetUrun>()
    set(value) {
        field = value
        notifyPropertyChanged(BR.sepettekiUrunler)
    }

    @get:Bindable
    var sepetGorunurlugu:Boolean = false
    set(value) {
        field = value
        notifyPropertyChanged(BR.sepetGorunurlugu)
    }

}