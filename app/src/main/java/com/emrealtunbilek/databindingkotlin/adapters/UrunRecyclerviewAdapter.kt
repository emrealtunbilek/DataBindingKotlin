package com.emrealtunbilek.databindingkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emrealtunbilek.databindingkotlin.databinding.TekSutunUrunLayoutBinding
import com.emrealtunbilek.databindingkotlin.models.Urun


class UrunRecyclerviewAdapter(urunler:ArrayList<Urun>, context: Context) : RecyclerView.Adapter<UrunRecyclerviewAdapter.MyViewHolder>() {

     var tumUrunler:List<Urun>
     var mContext:Context

    init {
        tumUrunler = urunler
        mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : TekSutunUrunLayoutBinding= TekSutunUrunLayoutBinding.inflate(LayoutInflater.from(mContext))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.urun = tumUrunler.get(position)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return tumUrunler.size
    }

    inner class MyViewHolder(var binding: TekSutunUrunLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}