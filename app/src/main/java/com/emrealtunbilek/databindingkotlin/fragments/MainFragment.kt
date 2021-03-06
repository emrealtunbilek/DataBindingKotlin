package com.emrealtunbilek.databindingkotlin.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.emrealtunbilek.databindingkotlin.adapters.UrunRecyclerviewAdapter
import com.emrealtunbilek.databindingkotlin.databinding.FragmentMainBinding
import com.emrealtunbilek.databindingkotlin.models.Urun
import com.emrealtunbilek.databindingkotlin.utils.TumUrunler


class MainFragment : Fragment() {

    val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val urunleriGetir = TumUrunler()

        binding.urunler = urunleriGetir.tumUrunlerDizisi.toCollection(ArrayList<Urun>())

        binding.refreshLayout.setOnRefreshListener {
            val yeniListe = urunleriGetir.tumUrunlerDizisi.toCollection(ArrayList<Urun>())
            (binding.urunListesi.adapter as UrunRecyclerviewAdapter).listeyiYenile(yeniListe)
            binding.refreshLayout.isRefreshing=false
        }

        return binding.root
    }


}
