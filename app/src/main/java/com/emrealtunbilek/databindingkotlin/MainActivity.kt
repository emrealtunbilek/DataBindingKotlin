package com.emrealtunbilek.databindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.emrealtunbilek.databindingkotlin.databinding.ActivityMainBinding
import com.emrealtunbilek.databindingkotlin.fragments.MainFragment
import com.emrealtunbilek.databindingkotlin.fragments.MiktarDialogFragment
import com.emrealtunbilek.databindingkotlin.fragments.UrunDetayFragment
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity
import com.emrealtunbilek.databindingkotlin.models.Urun

class MainActivity : AppCompatActivity(), IMainActivity {

    override fun urunEkle(urun: Urun, miktar: Int) {
        Log.e("EEE","SEPETE EKLENEN URUN ADI:"+urun.baslik+" miktarı:"+miktar)

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()


        val seriNumaralari:HashSet<String> = preferences.getStringSet("sepet_set",HashSet<String>()) as HashSet<String>
        seriNumaralari.add(urun.seriNumarasi.toString())
        editor.putStringSet("sepet_set",seriNumaralari)


        val suankiMiktar = preferences.getInt(urun.seriNumarasi.toString(), 0)
        editor.putInt(urun.seriNumarasi.toString(), (suankiMiktar)+miktar)


        editor.apply()



    }

    override fun miktarGuncelle(miktar: Int) {

        Log.e("EEE", "ACTİVİTYE GELEN MİKTAR:" + miktar)
        val detayFragment = supportFragmentManager.findFragmentByTag("urun_detay_fragment") as UrunDetayFragment
        detayFragment.binding.urunViewModel!!.miktar = miktar

    }

    override fun miktarFragmentBaslat() {
        val miktarFragment = MiktarDialogFragment()
        miktarFragment.show(supportFragmentManager, "miktar_dialog")
    }


    override fun secilenUruneGit(urun: Urun) {
        Log.e("EEE", "SECİLEN URUN :" + urun.baslik)

        val urunDetayFragment = UrunDetayFragment()
        val bundle = Bundle()
        bundle.putParcelable("secilen_urun", urun)
        urunDetayFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.anaContainer.id, urunDetayFragment, "urun_detay_fragment")
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
