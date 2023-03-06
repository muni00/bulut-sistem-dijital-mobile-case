package com.muazzeznihalbahadir.bulutbilisimmobilecase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.model.Reklamlar
import com.squareup.picasso.Picasso

class RVReklamAdapter(private val reklamList:ArrayList<Reklamlar>): RecyclerView.Adapter<RVReklamAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_reklam_tasarim,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = reklamList[position]
        holder.titleReklam.text = currentItem.reklamAd
        holder.titleBir.text = currentItem.birinciIcerik
        holder.titleIki.text = currentItem.ikinciIcerik
        Picasso.get().load(currentItem.resimAd).resize(100,100).into(holder.imageKategori)

        holder.titleReklam.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.tebrikGecis)
        }
    }

    override fun getItemCount(): Int {
        return reklamList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleReklam : TextView = itemView.findViewById(R.id.titleReklam)
        val imageKategori: ImageView = itemView.findViewById(R.id.imgReklam)
        val titleBir : TextView = itemView.findViewById(R.id.titleBir)
        val titleIki : TextView = itemView.findViewById(R.id.titleIki)
    }
}