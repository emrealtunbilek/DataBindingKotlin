package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emrealtunbilek.databindingkotlin.databinding.FragmentUrunDetayBinding
import com.emrealtunbilek.databindingkotlin.models.Urun


class UrunDetayFragment : Fragment() {

    val binding:FragmentUrunDetayBinding by lazy {
        FragmentUrunDetayBinding.inflate(layoutInflater)
    }

    lateinit var secilenUrun:Urun

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {


        if(arguments != null){
            this.secilenUrun =arguments!!.getParcelable("secilen_urun")!!
            binding.urun = secilenUrun
            binding.miktar = 1
        }






        return binding.root
    }


}
