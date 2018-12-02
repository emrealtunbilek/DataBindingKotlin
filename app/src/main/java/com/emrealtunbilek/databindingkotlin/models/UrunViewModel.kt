package com.emrealtunbilek.databindingkotlin.models

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

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

    fun getListener() : RequestListener<Drawable>{

        return object : RequestListener<Drawable>{
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                resimYuklendi = false
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                resimYuklendi = true
                return false
            }

        }

    }


}