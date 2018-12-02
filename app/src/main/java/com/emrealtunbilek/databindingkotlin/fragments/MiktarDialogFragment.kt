package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.emrealtunbilek.databindingkotlin.R
import com.emrealtunbilek.databindingkotlin.databinding.FragmentMiktarDialogBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MiktarDialogFragment : DialogFragment() {

    val binding: FragmentMiktarDialogBinding by lazy {
        FragmentMiktarDialogBinding.inflate(layoutInflater)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding.imageView3.setOnClickListener {
            dismiss()
        }

        return binding.root
    }


}
