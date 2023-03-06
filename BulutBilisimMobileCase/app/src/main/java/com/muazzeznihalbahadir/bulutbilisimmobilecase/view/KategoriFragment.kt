package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muazzeznihalbahadir.bulutbilisimmibilecase.adapter.RVKategoriAdapter
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentKategoriBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.model.Kategoriler
import com.muazzeznihalbahadir.bulutbilisimmobilecase.viewmodel.MainActivityViewModel

class KategoriFragment : Fragment() {

    private lateinit var adapter: RVKategoriAdapter
    private lateinit var kategoriList: ArrayList<Kategoriler>
    private lateinit var recyclerView: RecyclerView
    lateinit var textKategori :Array<String>
    lateinit var imageAdress :Array<String>
    private lateinit var binding: FragmentKategoriBinding
    private lateinit var  viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Ilan Ver - Kategori"
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kategori,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:MainActivityViewModel by viewModels()
        this.viewModel = tempViewModel

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager= LinearLayoutManager(context)
        recyclerView = binding.rvKategori
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RVKategoriAdapter(viewModel,kategoriList,"KategoriFragment")
        recyclerView.adapter = adapter
    }


    private fun dataInitialize(){

        kategoriList = arrayListOf<Kategoriler>()

        textKategori = arrayOf(
            "Telefon",
            "Bilgisayar",
            "Diğer"
        )
        imageAdress = arrayOf(
            "https://cdn-icons-png.flaticon.com/512/3415/3415074.png",
            "https://cdn-icons-png.flaticon.com/512/3474/3474360.png",
            "https://cdn-icons-png.flaticon.com/512/9822/9822914.png"
        )

        for(i in textKategori.indices){
            val kategori = Kategoriler(textKategori[i],imageAdress[i])
            kategoriList.add(kategori)
        }

    }
}