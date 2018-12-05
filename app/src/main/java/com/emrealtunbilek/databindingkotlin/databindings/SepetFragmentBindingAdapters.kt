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
        if(sepettekiUrunListesi == null){
            return
        }
        val mLayoutManager = LinearLayoutManager(recyclerView.context,RecyclerView.VERTICAL,false)

        if(recyclerView.layoutManager == null){
            recyclerView.layoutManager = mLayoutManager
        }

        var myAdapter = recyclerView.adapter as SepetRecyclerviewAdapter?

        if(myAdapter == null){
            myAdapter = SepetRecyclerviewAdapter(sepettekiUrunListesi)
            recyclerView.adapter = myAdapter
        }
        else{
            myAdapter.sepetiGuncelle(sepettekiUrunListesi)
        }
    }
}