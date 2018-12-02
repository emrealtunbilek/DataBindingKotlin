package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emrealtunbilek.databindingkotlin.databinding.FragmentUrunDetayBinding
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity
import com.emrealtunbilek.databindingkotlin.models.Urun
import com.emrealtunbilek.databindingkotlin.models.UrunViewModel


class UrunDetayFragment : Fragment() {

    val binding:FragmentUrunDetayBinding by lazy {
        FragmentUrunDetayBinding.inflate(layoutInflater)
    }

    lateinit var secilenUrun:Urun

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {

        if(arguments != null){
            this.secilenUrun =arguments!!.getParcelable("secilen_urun")!!

            var urunViewModel = UrunViewModel(secilenUrun, 1)
            urunViewModel.resimYuklendi=false
            binding.urunViewModel = urunViewModel
            binding.iMainInterface = activity as IMainActivity

        }

        return binding.root
    }


}
