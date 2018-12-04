package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.emrealtunbilek.databindingkotlin.databinding.FragmentSepetBinding
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity
import com.emrealtunbilek.databindingkotlin.models.SepetUrun
import com.emrealtunbilek.databindingkotlin.models.SepetViewModel
import com.emrealtunbilek.databindingkotlin.models.Urun
import com.emrealtunbilek.databindingkotlin.utils.TumUrunler


class SepetFragment : Fragment() {

    val binding: FragmentSepetBinding by lazy {

        FragmentSepetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding.iMainInterface = activity as IMainActivity

        binding.iMainInterface!!.sepetGorunurlugu(true)

        sepettekiUrunSayisiniGetir()

        return binding.root
    }

    fun sepettekiUrunSayisiniGetir(){
        val preferences = PreferenceManager.getDefaultSharedPreferences(activity)

        val seriNumaralari:HashSet<String> = preferences.getStringSet("sepet_set",HashSet<String>()) as HashSet<String>
        val mSepettekiUrunler = ArrayList<SepetUrun>()

        var mSepetViewModel = SepetViewModel()
        val tumUrunler= TumUrunler()

        for(seriNo in seriNumaralari){
            val urun: Urun = tumUrunler.tumUrunlerMap.get(seriNo)!!
            val miktar = preferences.getInt(seriNo,0)
            val arraylisteEklenecekSepetUrun = SepetUrun(urun,miktar)
            mSepettekiUrunler.add(arraylisteEklenecekSepetUrun)
        }

        mSepetViewModel.sepettekiUrunler  = mSepettekiUrunler
        mSepetViewModel.sepetGorunurlugu = true
        binding.sepetViewModel=mSepetViewModel

    }


    override fun onDestroy() {

        binding.iMainInterface!!.sepetGorunurlugu(false)
        super.onDestroy()
    }


}
