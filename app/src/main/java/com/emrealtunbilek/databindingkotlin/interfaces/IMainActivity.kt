package com.emrealtunbilek.databindingkotlin.interfaces

import com.emrealtunbilek.databindingkotlin.models.SepetUrun
import com.emrealtunbilek.databindingkotlin.models.Urun

interface IMainActivity {
    fun secilenUruneGit(urun:Urun)
    fun miktarFragmentBaslat()
    fun miktarGuncelle(miktar:Int)
    fun urunEkle(urun:Urun, miktar:Int)
    fun sepetGorunurlugu(goster:Boolean)
    fun sepetGuncelle(urun:Urun, miktar:Int)
    fun urunuSepettenSil(sepetUrun: SepetUrun)
}