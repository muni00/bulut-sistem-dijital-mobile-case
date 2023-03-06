package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muazzeznihalbahadir.bulutbilisimmibilecase.adapter.RVKategoriAdapter
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentMarkaBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.model.Kategoriler
import com.muazzeznihalbahadir.bulutbilisimmobilecase.viewmodel.MainActivityViewModel


class MarkaFragment : Fragment() {
    private lateinit var adapter: RVKategoriAdapter
    private lateinit var kategoriList: ArrayList<Kategoriler>
    private lateinit var recyclerView: RecyclerView
    lateinit var textKategori :Array<String>
    lateinit var imageAdress :Array<String>
    private lateinit var binding: FragmentMarkaBinding
    private lateinit var  viewModel: MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_marka,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "İlan Ver - Marka"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager= LinearLayoutManager(context)
        recyclerView = binding.rvMarka
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RVKategoriAdapter(viewModel,kategoriList,"MarkaFragment")
        recyclerView.adapter = adapter

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainActivityViewModel by viewModels()
        this.viewModel = tempViewModel
    }
    private fun dataInitialize(){

        kategoriList = arrayListOf<Kategoriler>()

        textKategori = arrayOf(
            "Samsung",
            "Sony",
            "Philips",
            "LG",
            "Vestel",
            "Arçelik",
            "Altus",
            "Beko",
        )
        imageAdress = arrayOf(
            "https://cdn-icons-png.flaticon.com/512/5969/5969116.png",
            "https://cdn-icons-png.flaticon.com/512/5969/5969151.png",
            "https://cdn-icons-png.flaticon.com/512/882/882805.png",
            "https://cdn-icons-png.flaticon.com/512/882/882824.png",
            "Vestel",
            "Arçelik",
            "Altus",
            "Beko",
        )

        for(i in textKategori.indices){
            val kategori = Kategoriler(textKategori[i],imageAdress[i])
            kategoriList.add(kategori)
        }

    }
}