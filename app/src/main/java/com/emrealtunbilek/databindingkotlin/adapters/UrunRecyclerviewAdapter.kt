package com.emrealtunbilek.databindingkotlin.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.emrealtunbilek.databindingkotlin.R
import com.emrealtunbilek.databindingkotlin.databinding.TekSutunUrunLayoutBinding
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity
import com.emrealtunbilek.databindingkotlin.models.Urun
import com.emrealtunbilek.databindingkotlin.models.UrunViewModel


class UrunRecyclerviewAdapter(urunler:ArrayList<Urun>, context: Context) : RecyclerView.Adapter<UrunRecyclerviewAdapter.MyViewHolder>() {

     var tumUrunler:ArrayList<Urun>
     var mContext:Context
     var mMainActivityInterface:IMainActivity

    init {
        tumUrunler = urunler
        mContext = context
        mMainActivityInterface = mContext as IMainActivity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : TekSutunUrunLayoutBinding= TekSutunUrunLayoutBinding.inflate(LayoutInflater.from(mContext))
        //val binding2 = DataBindingUtil.inflate<TekSutunUrunLayoutBinding>(LayoutInflater.from(mContext),R.layout.tek_sutun_urun_layout,parent,false)
        return MyViewHolder(binding)
    }

    fun listeyiYenile(yeniListe:ArrayList<Urun>){
        tumUrunler.clear()
        notifyItemRangeRemoved(0,yeniListe.size)
        tumUrunler.addAll(yeniListe)
        notifyItemInserted(0)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var mUrunViewHolder = UrunViewModel(tumUrunler.get(position), 1)

        holder.binding.urunViewHolder = mUrunViewHolder

        holder.binding.mainActivityInterface=mMainActivityInterface
        //holder.binding.stringUrl="https://pixelz.cc/wp-content/uploads/2016/11/annapurna-massif-himalayas-nepal-4k-wallpaper.jpg"

       // holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return tumUrunler.size
    }

    inner class MyViewHolder(var binding: TekSutunUrunLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}