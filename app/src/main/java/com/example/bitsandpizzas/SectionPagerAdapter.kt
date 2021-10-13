package com.example.bitsandpizzas

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionPagerAdapter(fragmentManager: FragmentManager, resources: Resources):
    FragmentPagerAdapter(fragmentManager) {
    val mResources = resources
    override fun getCount(): Int {
        return  4
    }
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> TopFragment()
            1 -> PizzaFragment()
            2 -> PastaFragment()
            else -> StoresFragment()
        }
    }
    override fun getPageTitle(position: Int): CharSequence {
        return mResources.getString(when (position) {
            0 -> R.string.home_tab
            1 -> R.string.pizza_tab
            2 -> R.string.pasta_tab
            else -> R.string.stores_tab
        })
    }
}