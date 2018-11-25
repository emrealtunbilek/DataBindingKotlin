package com.emrealtunbilek.databindingkotlin.databindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.emrealtunbilek.databindingkotlin.R

object GlideBindingAdapters {

    @JvmStatic
    @BindingAdapter("resimGoster")
    fun resimleriGlideileGoster(imageView: ImageView, resimYolu:Int){
        //imageView.setImageResource(resimYolu)

        var options=RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(imageView.context)
            .setDefaultRequestOptions(options)
            .load(resimYolu)
            .into(imageView)
    }



    @JvmStatic
    @BindingAdapter("resimGoster")
    fun resimleriGlideileGoster(imageView: ImageView, resimYolu:String){
        //imageView.setImageResource(resimYolu)

        var options=RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(imageView.context)
            .setDefaultRequestOptions(options)
            .load(resimYolu)
            .into(imageView)
    }
}