package com.emrealtunbilek.databindingkotlin.databindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emrealtunbilek.databindingkotlin.adapters.UrunRecyclerviewAdapter
import com.emrealtunbilek.databindingkotlin.models.Urun

object MainFragmentBindingAdapters {

    @JvmStatic
    @BindingAdapter("urunlerListesiniGoster")
    fun urunlerListesiniGoster(recyclerView: RecyclerView, urunListesi:ArrayList<Urun>?){

        if(urunListesi == null){
            return
        }
        val mLayoutManager = GridLayoutManager(recyclerView.context,2)
        if(recyclerView.layoutManager == null){
            recyclerView.layoutManager = mLayoutManager
        }

        var myAdapter = recyclerView.adapter as UrunRecyclerviewAdapter?

        if(myAdapter == null){
            myAdapter = UrunRecyclerviewAdapter(urunListesi,recyclerView.context)
            recyclerView.adapter = myAdapter
        }

    }




}