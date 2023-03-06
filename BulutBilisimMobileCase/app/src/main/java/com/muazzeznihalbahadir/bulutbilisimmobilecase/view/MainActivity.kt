package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.ActivityMainBinding
import com.muazzeznihalbahadir.bulutbilisimmobilecase.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivitiNesnesi = this

        viewModel.kategoriText.observe(this) {
            binding.kategoriText = it.toString()
        }
        viewModel.progressbarSonuc.observe(this) { s ->
            binding.progressbarSonuc = s
        }

    }

}