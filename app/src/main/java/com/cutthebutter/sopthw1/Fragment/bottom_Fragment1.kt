package com.cutthebutter.sopthw1.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.cutthebutter.sopthw1.R
import com.cutthebutter.sopthw1.TabPagerAdapter
import com.cutthebutter.sopthw1.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout


class bottom_Fragment1 : Fragment() {
    private lateinit var viewpagerAdapter: TabPagerAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_1, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewpagerAdapter= TabPagerAdapter(childFragmentManager)

        val homeTabViewPager = view.findViewById<ViewPager>(R.id.homeTabViewPager)

        homeTabViewPager.adapter = viewpagerAdapter

        val homeTab = view.findViewById<TabLayout>(R.id.homeTab)

        homeTab.setupWithViewPager(homeTabViewPager)
        homeTab.apply{
            getTabAt(0)?.text = "Info"
            getTabAt(1)?.text ="Other"
        }

        super.onViewCreated(view, savedInstanceState)


    }


    }
