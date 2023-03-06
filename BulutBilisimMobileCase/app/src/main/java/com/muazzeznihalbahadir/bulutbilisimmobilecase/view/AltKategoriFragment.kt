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
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentAltKategoriBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.model.Kategoriler
import com.muazzeznihalbahadir.bulutbilisimmobilecase.viewmodel.MainActivityViewModel

class AltKategoriFragment : Fragment() {

    private lateinit var adapter: RVKategoriAdapter
    private lateinit var kategoriList: ArrayList<Kategoriler>
    private lateinit var recyclerView: RecyclerView
    lateinit var textKategori :Array<String>
    lateinit var imageAdress :Array<String>
    private lateinit var binding: FragmentAltKategoriBinding
    private lateinit var  viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_alt_kategori,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "İlan Ver - Alt Kategori"
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainActivityViewModel by viewModels()
        this.viewModel = tempViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager= LinearLayoutManager(context)
        recyclerView = binding.rvAltKategori
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RVKategoriAdapter(viewModel,kategoriList,"AltKategoriFragment")
        recyclerView.adapter = adapter

    }
    private fun dataInitialize(){

        kategoriList = arrayListOf<Kategoriler>()

        textKategori = arrayOf(
            "Televizyon",
            "Medya Oynatici",
            "Monitör",
            "Drone",
            "Uydu Alıcısı",
            "Kulaklık",
            "VR Gözlük",
            "Modem",
        )
        imageAdress = arrayOf(
            "https://cdn-icons-png.flaticon.com/512/4540/4540211.png",
            "https://cdn-icons-png.flaticon.com/512/9652/9652179.png",
            "https://cdn-icons-png.flaticon.com/512/9368/9368749.png",
            "https://cdn-icons-png.flaticon.com/512/7504/7504454.png",
            "https://cdn-icons-png.flaticon.com/512/2939/2939474.png",
            "https://cdn-icons-png.flaticon.com/512/2353/2353224.png",
            "https://cdn-icons-png.flaticon.com/512/3646/3646958.png",
            "https://cdn-icons-png.flaticon.com/512/2876/2876882.png",
        )
        for(i in textKategori.indices){
            val kategori = Kategoriler(textKategori[i],imageAdress[i])
            kategoriList.add(kategori)
        }

    }
}