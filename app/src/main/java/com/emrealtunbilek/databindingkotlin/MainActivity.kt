package com.emrealtunbilek.databindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.emrealtunbilek.databindingkotlin.databinding.ActivityMainBinding
import com.emrealtunbilek.databindingkotlin.fragments.MainFragment
import com.emrealtunbilek.databindingkotlin.fragments.UrunDetayFragment
import com.emrealtunbilek.databindingkotlin.utils.TumUrunler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentBaslat()
    }

    private fun fragmentBaslat() {

        /*
               val urunDetayFragment = UrunDetayFragment()
               val transaction = supportFragmentManager.beginTransaction()
               transaction.replace(binding.anaContainer.id, urunDetayFragment,"urun_detay_fragment")
               transaction.commit()*/


        val mainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.anaContainer.id, mainFragment, "main_fragment")
        transaction.commit()
               

    }


}
