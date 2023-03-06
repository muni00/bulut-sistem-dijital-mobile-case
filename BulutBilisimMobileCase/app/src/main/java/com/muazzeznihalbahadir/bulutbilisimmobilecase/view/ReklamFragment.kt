package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.adapter.RVReklamAdapter
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.ActivityMainBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentReklamBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.model.Reklamlar

class ReklamFragment : Fragment() {
    private lateinit var adapter: RVReklamAdapter
    private lateinit var reklamList: ArrayList<Reklamlar>
    lateinit var textReklamBaslik :Array<String>
    lateinit var textBirinciIcerik :Array<String>
    lateinit var textIkinciIcerik :Array<String>
    lateinit var resimAd :Array<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentReklamBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_reklam,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Reklam"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager= LinearLayoutManager(context)
        recyclerView = binding.rvReklam
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RVReklamAdapter(reklamList)
        recyclerView.adapter = adapter


    }
    private fun dataInitialize(){

        reklamList = arrayListOf<Reklamlar>()

        textReklamBaslik = arrayOf(
            "Ana Sayfa Reklam",
            "Kategori Reklam",
            "Üst Sıra Reklam",
            "Güncel Reklam",
            "Acil reklam",
        )
        textBirinciIcerik = arrayOf(
            "İçerik 1 burada görüntülenir",
            "İçerik 1 burada görüntülenir",
            "İçerik 1 burada görüntülenir",
            "İçerik 1 burada görüntülenir",
            "İçerik 1 burada görüntülenir",
        )
        textIkinciIcerik = arrayOf(
            "İçerik 2 burada görüntülenir",
            "İçerik 2 burada görüntülenir",
            "İçerik 2 burada görüntülenir",
            "İçerik 2 burada görüntülenir",
            "İçerik 2 burada görüntülenir",
        )
        resimAd = arrayOf(
            "https://cdn-icons-png.flaticon.com/512/3094/3094357.png",
            "https://cdn-icons-png.flaticon.com/512/7479/7479956.png",
            "https://cdn-icons-png.flaticon.com/512/9018/9018788.png",
            "https://cdn-icons-png.flaticon.com/512/7323/7323230.png",
            "https://cdn-icons-png.flaticon.com/512/1827/1827422.png",
        )

        for(i in textReklamBaslik.indices){
            val reklam = Reklamlar(textReklamBaslik[i],textBirinciIcerik[i],textIkinciIcerik[i],resimAd[i])
            reklamList.add(reklam)
        }

    }
}