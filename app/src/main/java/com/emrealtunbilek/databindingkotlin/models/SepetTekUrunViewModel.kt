package com.emrealtunbilek.databindingkotlin.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.emrealtunbilek.databindingkotlin.BR

class SepetTekUrunViewModel: BaseObservable() {

    @get:Bindable
    var sepetTekUrun : SepetUrun? = null
    set(value) {
        field = value
        notifyPropertyChanged(BR.sepetTekUrun)
    }

}