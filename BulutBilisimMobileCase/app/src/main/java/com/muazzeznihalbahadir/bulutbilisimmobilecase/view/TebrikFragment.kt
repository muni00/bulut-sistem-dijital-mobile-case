package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.ActivityMainBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentTebrikBinding

class TebrikFragment : Fragment() {
    private lateinit var binding: FragmentTebrikBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tebrik,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Tebrikler"
        binding.btnAnaSayfayaDon.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kategoriGecis)
        }
        return binding.root
    }

}