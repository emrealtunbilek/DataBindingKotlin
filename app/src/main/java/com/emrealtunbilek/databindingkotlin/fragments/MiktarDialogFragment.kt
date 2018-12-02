package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.emrealtunbilek.databindingkotlin.R
import com.emrealtunbilek.databindingkotlin.databinding.FragmentMiktarDialogBinding
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity


class MiktarDialogFragment : DialogFragment() {

    val binding: FragmentMiktarDialogBinding by lazy {
        FragmentMiktarDialogBinding.inflate(layoutInflater)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding.imageView3.setOnClickListener {
            dialog.dismiss()
        }

        binding.miktarListesi.setOnItemClickListener { parent, view, position, id ->
            Log.e("EEE","SEÇİLEN MİKTAR :"+parent.getItemAtPosition(position))
            var secilenMiktar = parent.getItemAtPosition(position) as String
            (activity as IMainActivity).miktarGuncelle(secilenMiktar.toInt())

            dialog.dismiss()
        }

        return binding.root
    }


}
