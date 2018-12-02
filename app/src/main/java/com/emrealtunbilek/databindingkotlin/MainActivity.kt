package com.emrealtunbilek.databindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.emrealtunbilek.databindingkotlin.databinding.ActivityMainBinding
import com.emrealtunbilek.databindingkotlin.fragments.MainFragment
import com.emrealtunbilek.databindingkotlin.fragments.MiktarDialogFragment
import com.emrealtunbilek.databindingkotlin.fragments.UrunDetayFragment
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity
import com.emrealtunbilek.databindingkotlin.models.Urun

class MainActivity : AppCompatActivity(), IMainActivity{

    override fun miktarFragmentBaslat() {
        val miktarFragment = MiktarDialogFragment()
        miktarFragment.show(supportFragmentManager,"miktar_dialog")
    }


    override fun secilenUruneGit(urun: Urun) {
        Log.e("EEE","SECİLEN URUN :"+urun.baslik)

        val urunDetayFragment = UrunDetayFragment()
        val bundle=Bundle()
        bundle.putParcelable("secilen_urun",urun)
        urunDetayFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.anaContainer.id, urunDetayFragment,"urun_detay_fragment")
        transaction.addToBackStack("urun_detay_fragment")
        transaction.commit()
    }

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentBaslat()

    }

    private fun fragmentBaslat() {

        val mainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.anaContainer.id, mainFragment, "main_fragment")
        transaction.commit()


    }


}
