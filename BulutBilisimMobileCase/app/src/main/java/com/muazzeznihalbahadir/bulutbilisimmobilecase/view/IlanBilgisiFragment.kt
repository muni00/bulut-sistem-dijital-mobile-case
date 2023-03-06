package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentAltKategoriBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentIlanBilgisiBinding

class IlanBilgisiFragment : Fragment() {

    private lateinit var binding: FragmentIlanBilgisiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ilan_bilgisi,container,false)
        binding.txtIlanKategorisi.setSingleLine()
        binding.txtIlanKategorisi.isSelected = true
        binding.txtIlanKategorisi.text = "https://www.mobilhanem.com/android-textview-ve-autocompletetextview-kullanimi/"

        binding.txtIlanaGit.setSingleLine()
        binding.txtIlanaGit.isSelected = true
        binding.txtIlanaGit.text = "https://www.mobilhanem.com/android-textview-ve-autocompletetextview-kullanimi/"
        return binding.root
    }

}