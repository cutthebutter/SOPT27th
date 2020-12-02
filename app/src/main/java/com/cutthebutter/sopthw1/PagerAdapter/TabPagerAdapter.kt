package com.cutthebutter.sopthw1.PagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cutthebutter.sopthw1.Fragment.tab_Fragment1
import com.cutthebutter.sopthw1.Fragment.tab_Fragment2

class TabPagerAdapter (fm : FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment = when(position){
        0 -> tab_Fragment1()
        1 -> tab_Fragment2()
        else -> throw IllegalStateException("Unexpcted position $position")
    }
    override fun getCount(): Int = 2
}