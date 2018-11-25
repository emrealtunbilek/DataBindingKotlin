package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emrealtunbilek.databindingkotlin.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {




        return binding.root
    }


}
