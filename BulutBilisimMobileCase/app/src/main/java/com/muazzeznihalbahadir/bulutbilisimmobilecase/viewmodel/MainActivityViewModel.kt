package com.muazzeznihalbahadir.bulutbilisimmobilecase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var progressbarSonuc = MutableLiveData<Int>()
    var kategoriText = MutableLiveData<String>()

    init {
        progressbarSonuc = MutableLiveData<Int>(20)
        kategoriText = MutableLiveData<String>("nihal")
    }

    fun progressIlerlet(){
        progressbarSonuc.value = 50
    }

    fun kategoriTextBelirle(txtKategori:String){
        kategoriText.value = txtKategori
    }
}