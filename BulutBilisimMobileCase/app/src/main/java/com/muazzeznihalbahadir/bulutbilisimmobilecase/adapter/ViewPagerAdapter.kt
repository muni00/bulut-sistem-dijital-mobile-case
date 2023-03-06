package com.muazzeznihalbahadir.bulutbilisimmobilecase.adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.muazzeznihalbahadir.bulutbilisimmobilecase.view.IlanAciklamaFragment
import com.muazzeznihalbahadir.bulutbilisimmobilecase.view.IlanBilgisiFragment
import com.muazzeznihalbahadir.bulutbilisimmobilecase.view.KategoriFragment

private const val NUM_TABS = 2

 class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return IlanBilgisiFragment()
            1 -> return IlanAciklamaFragment()
        }
        return KategoriFragment()
    }
}