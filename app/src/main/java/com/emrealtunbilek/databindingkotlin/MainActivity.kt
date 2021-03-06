package com.emrealtunbilek.databindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.emrealtunbilek.databindingkotlin.databinding.ActivityMainBinding
import com.emrealtunbilek.databindingkotlin.fragments.MainFragment
import com.emrealtunbilek.databindingkotlin.fragments.MiktarDialogFragment
import com.emrealtunbilek.databindingkotlin.fragments.SepetFragment
import com.emrealtunbilek.databindingkotlin.fragments.UrunDetayFragment
import com.emrealtunbilek.databindingkotlin.interfaces.IMainActivity
import com.emrealtunbilek.databindingkotlin.models.SepetUrun
import com.emrealtunbilek.databindingkotlin.models.SepetViewModel
import com.emrealtunbilek.databindingkotlin.models.Urun
import com.emrealtunbilek.databindingkotlin.utils.TumUrunler
import java.lang.Exception

class MainActivity : AppCompatActivity(), IMainActivity {

    var cikmakIcinTikla = false

    override fun urunuSepettenSil(sepetUrun: SepetUrun) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()

        editor.remove(sepetUrun.urun.seriNumarasi.toString())
        editor.apply()

        val seriNumaralari:HashSet<String> = preferences.getStringSet("sepet_set",HashSet<String>()) as HashSet<String>

        if(seriNumaralari.size == 1){
            editor.remove("sepet_set")
            editor.apply()
        }else{

            seriNumaralari.remove(sepetUrun.urun.seriNumarasi.toString())
            editor.putStringSet("sepet_set",seriNumaralari)
            editor.apply()
        }

        sepettekiUrunSayisiniGetir()

        val sepetFragment=supportFragmentManager.findFragmentByTag("sepet_fragment") as SepetFragment

        sepetFragment.sepetiGuncelle()



    }


    override fun sepetGuncelle(urun: Urun, miktar: Int) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()

        var suanKiMiktar = preferences.getInt(urun.seriNumarasi.toString(), 0)

        editor.putInt(urun.seriNumarasi.toString(), (suanKiMiktar+miktar))
        editor.apply()

        sepettekiUrunSayisiniGetir()
    }

    override fun sepetGorunurlugu(goster: Boolean) {
        binding.sepetViewModel!!.sepetGorunurlugu = goster
    }

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
        miktarGuncelle(1)
        sepettekiUrunSayisiniGetir()



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

        mainFragmentiBaslat()
        sepettekiUrunSayisiniGetir()
        initLayout()


    }

    private fun initLayout() {

        binding.imageView2.setOnClickListener {

            var sepetFragment = supportFragmentManager.findFragmentByTag("sepet_fragment")
            if(sepetFragment == null){
                sepetFragment = SepetFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(binding.anaContainer.id, sepetFragment,"sepet_fragment")
                transaction.addToBackStack("sepet_fragment")
                transaction.commit()
            }

        }

        binding.btnTamamla.setOnClickListener {

            binding.progressBar3.visibility= View.VISIBLE
            object : CountDownTimer(2000,2000){
                override fun onFinish() {
                    binding.progressBar3.visibility=View.GONE
                    sepettekiTumUrunleriSil()
                }

                override fun onTick(millisUntilFinished: Long) {

                }


            }.start()



        }

    }

    private fun sepettekiTumUrunleriSil() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()


        val seriNumaralari:HashSet<String> = preferences.getStringSet("sepet_set",HashSet<String>()) as HashSet<String>
        for (seriNo in seriNumaralari){
            editor.remove(seriNo)
            editor.apply()
        }

        editor.remove("sepet_set")
        editor.apply()

        Toast.makeText(this,"Alışveriş için teşekkürler",Toast.LENGTH_LONG).show()
        anaSayfayaGit()
        sepettekiUrunSayisiniGetir()
    }

    private fun anaSayfayaGit() {
        supportFragmentManager.popBackStack()
    }

    override fun onBackPressed() {

        var backStackFragmentSayisi = supportFragmentManager.backStackEntryCount

        if(backStackFragmentSayisi == 0 && cikmakIcinTikla){
            super.onBackPressed()
        }

        if(backStackFragmentSayisi == 0 && !cikmakIcinTikla){
            Toast.makeText(this,"Çıkmak için tekrar geriye tıklayın",Toast.LENGTH_LONG).show()
            cikmakIcinTikla = true
        }else{
            cikmakIcinTikla = false
            super.onBackPressed()
        }


    }

    fun sepettekiUrunSayisiniGetir(){
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)

        val seriNumaralari:HashSet<String> = preferences.getStringSet("sepet_set",HashSet<String>()) as HashSet<String>
        val mSepettekiUrunler = ArrayList<SepetUrun>()

        var mSepetViewModel = SepetViewModel()
        val tumUrunler=TumUrunler()

        for(seriNo in seriNumaralari){
            val urun:Urun= tumUrunler.tumUrunlerMap.get(seriNo)!!
            val miktar = preferences.getInt(seriNo,0)
            val arraylisteEklenecekSepetUrun = SepetUrun(urun,miktar)
            mSepettekiUrunler.add(arraylisteEklenecekSepetUrun)
        }

        try {
            mSepetViewModel.sepetGorunurlugu = binding.sepetViewModel?.sepetGorunurlugu!!
        }catch (e:Exception){
            Log.e("EEE","BEKLENEN HATA:"+e.message)
        }

        mSepetViewModel.sepettekiUrunler  = mSepettekiUrunler
        binding.sepetViewModel=mSepetViewModel

    }

    private fun mainFragmentiBaslat() {

        val mainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.anaContainer.id, mainFragment, "main_fragment")
        transaction.commit()


    }


}
