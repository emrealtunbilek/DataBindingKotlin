package com.emrealtunbilek.databindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.emrealtunbilek.databindingkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) //activity_ogrenci ActivityOgrenciBinding
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)



        val yeniOgrenci = Ogrenci("Yeni Ogrenci 2", 1500)
      /*  binding.tvOgrenciAdi.setText(yeniOgrenci.isim)
        binding.tvNumara.setText(""+yeniOgrenci.numara)*/

        binding.ogr = yeniOgrenci





    }
}
