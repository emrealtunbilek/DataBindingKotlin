package com.emrealtunbilek.databindingkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emrealtunbilek.databindingkotlin.databinding.TekSatirSepetUrunBinding
import com.emrealtunbilek.databindingkotlin.models.SepetTekUrunViewModel
import com.emrealtunbilek.databindingkotlin.models.SepetUrun

class SepetRecyclerviewAdapter(sepettekiUrunler:ArrayList<SepetUrun>) : RecyclerView.Adapter<SepetRecyclerviewAdapter.MyViewHolder>() {

    var sepettekiUrunlerim:ArrayList<SepetUrun>

    init {
      sepettekiUrunlerim = sepettekiUrunler
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding:TekSatirSepetUrunBinding = TekSatirSepetUrunBinding.inflate(LayoutInflater.from(parent.context))

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sepettekiUrunlerim.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var mSepeturun = sepettekiUrunlerim.get(position)
        var mSepetUrunViewModel = SepetTekUrunViewModel()
        mSepetUrunViewModel.sepetTekUrun = mSepeturun
        holder.binding.tekSepetUrun = mSepetUrunViewModel
    }


    inner class MyViewHolder(var binding: TekSatirSepetUrunBinding) : RecyclerView.ViewHolder(binding.root)
}