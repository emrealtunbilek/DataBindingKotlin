package com.emrealtunbilek.databindingkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.emrealtunbilek.databindingkotlin.R
import com.emrealtunbilek.databindingkotlin.models.Urun
import kotlinx.android.synthetic.main.tek_sutun_urun_layout.view.*

class UrunRecyclerviewAdapter(urunler:ArrayList<Urun>, context: Context) : RecyclerView.Adapter<UrunRecyclerviewAdapter.MyViewHolder>() {

     var tumUrunler:List<Urun>
     var mContext:Context

    init {
        tumUrunler = urunler
        mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.tek_sutun_urun_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(tumUrunler.get(position) ,position)
    }

    override fun getItemCount(): Int {
        return tumUrunler.size
    }



    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tumLayout = itemView as ConstraintLayout
        var urunBaslik = tumLayout.tvurunBaslik
        var urunFiyat = tumLayout.tvFiyat

        fun setData(oanOlusturulanUrun: Urun, position: Int) {

            urunBaslik.setText(oanOlusturulanUrun.baslik)
            urunFiyat.setText(""+oanOlusturulanUrun.fiyat)
            
        }


    }
}