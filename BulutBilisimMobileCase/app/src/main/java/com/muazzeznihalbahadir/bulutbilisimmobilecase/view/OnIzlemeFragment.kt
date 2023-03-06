package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayoutMediator
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.adapter.ViewPagerAdapter
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentOnIzlemeBinding

class OnIzlemeFragment : Fragment() {
    private lateinit var binding: FragmentOnIzlemeBinding
    val tabArray = arrayOf(
        "İlan Bilgisi",
        "İlan Açıklaması",
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_on_izleme,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Ön İzleme"
        val adapter = ViewPagerAdapter((activity as AppCompatActivity).supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabArray[position]
        }.attach()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView5.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.reklamGecis)
        }
    }

}