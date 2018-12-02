package com.emrealtunbilek.databindingkotlin.databindings

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestListener
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


    @JvmStatic
    @BindingAdapter(value = arrayOf("listenerAta","resimGoster"),requireAll = true)
    fun resimleriGlideileGosterwithListener(imageView: ImageView, requestListener: RequestListener<Drawable>, resimYolu:Int){
        //imageView.setImageResource(resimYolu)

        var options=RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(imageView.context)
            .setDefaultRequestOptions(options)
            .load(resimYolu)
            .listener(requestListener)
            .into(imageView)
    }

}