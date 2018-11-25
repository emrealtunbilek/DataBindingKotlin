package com.emrealtunbilek.databindingkotlin.databindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emrealtunbilek.databindingkotlin.adapters.UrunRecyclerviewAdapter
import com.emrealtunbilek.databindingkotlin.models.Urun

object MainFragmentBindingAdapters {

    @JvmStatic
    @BindingAdapter("urunlerListesiniGoster")
    fun urunlerListesiniGoster(recyclerView: RecyclerView, urunListesi:ArrayList<Urun>){
        if(urunListesi.size ==0){
            return
        }
        val mLayoutManager = GridLayoutManager(recyclerView.context,2)
        if(recyclerView.layoutManager == null){
            recyclerView.layoutManager = mLayoutManager
        }
        val mAdapter = UrunRecyclerviewAdapter(urunListesi, recyclerView.context)
        if(recyclerView.adapter == null){
            recyclerView.adapter=mAdapter
        }
    }


}