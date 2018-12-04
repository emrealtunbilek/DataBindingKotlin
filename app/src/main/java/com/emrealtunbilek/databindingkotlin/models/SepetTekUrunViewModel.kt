package com.emrealtunbilek.databindingkotlin.models

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.emrealtunbilek.databindingkotlin.BR
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity

class SepetTekUrunViewModel: BaseObservable() {

    @get:Bindable
    var sepetTekUrun : SepetUrun? = null
    set(value) {
        field = value
        notifyPropertyChanged(BR.sepetTekUrun)
    }

    fun miktarArtir(context: Context){

        val oankiSepetTekUrun:SepetUrun = sepetTekUrun!!
        oankiSepetTekUrun.miktar = oankiSepetTekUrun.miktar + 1
        sepetTekUrun = oankiSepetTekUrun

        val iMainInterface = context as IMainActivity
        iMainInterface.sepetGuncelle(sepetTekUrun?.urun!!, 1)



    }

    fun miktarAzalt(context: Context){
        val oankiSepetTekUrun:SepetUrun = sepetTekUrun!!
        if (oankiSepetTekUrun.miktar > 1){
            oankiSepetTekUrun.miktar = oankiSepetTekUrun.miktar -1
            sepetTekUrun = oankiSepetTekUrun

            val iMainInterface = context as IMainActivity
            iMainInterface.sepetGuncelle(sepetTekUrun?.urun!!, -1)
        }
    }

}