package com.emrealtunbilek.databindingkotlin.databindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emrealtunbilek.databindingkotlin.adapters.SepetRecyclerviewAdapter
import com.emrealtunbilek.databindingkotlin.models.SepetUrun

object SepetFragmentBindingAdapters {

    @JvmStatic
    @BindingAdapter("sepettekiUrunlerListesiniGoster")
    fun urunlerListesiniGoster(recyclerView: RecyclerView, sepettekiUrunListesi:ArrayList<SepetUrun>){
        if(sepettekiUrunListesi.size ==0){
            return
        }
        val mLayoutManager = LinearLayoutManager(recyclerView.context,RecyclerView.VERTICAL,false)
        if(recyclerView.layoutManager == null){
            recyclerView.layoutManager = mLayoutManager
        }
        val mAdapter = SepetRecyclerviewAdapter(sepettekiUrunListesi)
        if(recyclerView.adapter == null){
            recyclerView.adapter=mAdapter
        }
    }
}