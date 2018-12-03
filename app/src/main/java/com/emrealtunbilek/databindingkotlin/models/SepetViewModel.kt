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

    fun sepettekiToplamUrunSayisi():String{

        var toplamUrunSayisi = 0

        for(urun in sepettekiUrunler){
            toplamUrunSayisi = toplamUrunSayisi + urun.miktar
        }

        return "Sepette $toplamUrunSayisi ürün var. Toplam :"



    }

    fun sepettekiUrunlerinToplamTutariniBul():String{

        var toplamTutar:Double = 0.0

        for (gezilenUrunMiktar in sepettekiUrunler){

            if(gezilenUrunMiktar.urun.kampanyaliFiyat == 0.toDouble()){
                toplamTutar = toplamTutar + (gezilenUrunMiktar.urun.fiyat)*gezilenUrunMiktar.miktar
            }else{
                toplamTutar = toplamTutar + (gezilenUrunMiktar.urun.kampanyaliFiyat) * gezilenUrunMiktar.miktar
            }
        }

        var formatlanmisTutar = String.format("%.2f",toplamTutar)

        return formatlanmisTutar +" TL"


    }

}