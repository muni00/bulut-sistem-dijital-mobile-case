package com.muazzeznihalbahadir.bulutbilisimmibilecase.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.ActivityMainBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.model.Kategoriler
import com.muazzeznihalbahadir.bulutbilisimmobilecase.viewmodel.MainActivityViewModel
import com.squareup.picasso.Picasso

class RVKategoriAdapter(private val viewmodel:MainActivityViewModel,private val kategoriList:ArrayList<Kategoriler>,var fragmentAdi : String): Adapter<RVKategoriAdapter.ViewHolder>() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_kategori_tasarim,parent,false)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = kategoriList[position]
        holder.titleKategori.text = currentItem.kategoriAd
        degerAl(holder.titleKategori,fragmentAdi)
        Picasso.get().load(currentItem.imageAdress).resize(60,60).into(holder.imageKategori)

    }

    override fun getItemCount(): Int {
        return kategoriList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleKategori : TextView = itemView.findViewById(R.id.txtKategori)
        val imageKategori: ImageView  = itemView.findViewById(R.id.kategoriImage)
    }

    fun degerAl(titleKategori:TextView,fragmentAdi: String){
        titleKategori.setOnClickListener {
            when (fragmentAdi) {
                "KategoriFragment" ->{
                    Navigation.findNavController(it).navigate(R.id.altKategoriyeGecis)
                    viewmodel.kategoriTextBelirle("nihal")
                }
                "AltKategoriFragment" ->{
                    Navigation.findNavController(it).navigate(R.id.markaGecis)
                    viewmodel.kategoriTextBelirle("nihal")
                }
                "MarkaFragment" ->{
                    Navigation.findNavController(it).navigate(R.id.ilanDetayGecis)
                    viewmodel.progressIlerlet()
                    viewmodel.kategoriTextBelirle("nihal")
                }
                else -> println("boş")
            }

        }
    }
}