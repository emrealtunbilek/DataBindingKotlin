package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.emrealtunbilek.databindingkotlin.databinding.FragmentSepetBinding
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity


class SepetFragment : Fragment() {

    val binding: FragmentSepetBinding by lazy {

        FragmentSepetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding.iMainInterface = activity as IMainActivity

        binding.iMainInterface!!.sepetGorunurlugu(true)

        return binding.root
    }

    override fun onDestroy() {

        binding.iMainInterface!!.sepetGorunurlugu(false)
        super.onDestroy()
    }


}
