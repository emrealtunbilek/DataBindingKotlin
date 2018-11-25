package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emrealtunbilek.databindingkotlin.databinding.FragmentUrunDetayBinding
import com.emrealtunbilek.databindingkotlin.utils.TumUrunler


class UrunDetayFragment : Fragment() {

    val binding:FragmentUrunDetayBinding by lazy {
        FragmentUrunDetayBinding.inflate(layoutInflater)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {

        val denemeUrun = TumUrunler()


        binding.urun = denemeUrun.tumUrunlerDizisi.get(0)
        binding.miktar = 5

        return binding.root
    }


}
