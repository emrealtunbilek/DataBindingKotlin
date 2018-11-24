package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.emrealtunbilek.databindingkotlin.R

class UrunDetayFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        return inflater.inflate(R.layout.fragment_urun_detay, container, false)
    }


}
