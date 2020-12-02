package com.cutthebutter.sopthw1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.cutthebutter.sopthw1.Fragment.bottom_Fragment1
import com.cutthebutter.sopthw1.Fragment.bottom_Fragment2
import com.cutthebutter.sopthw1.Fragment.bottom_Fragment3
import com.cutthebutter.sopthw1.PagerAdapter.ViewPagerAdapter
import com.cutthebutter.sopthw1.R

import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlin.properties.Delegates

class HomeActivity : AppCompatActivity() {
    private lateinit var viewpagerAdapter: ViewPagerAdapter
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
//        val profileBtn =findViewById<Button>(R.id.profileBtn)

        val home_bottom_viewPager =findViewById<ViewPager>(R.id.home_bottom_viewPager)
        val home_bottom_navi= findViewById<BottomNavigationView>(R.id.home_bottom_navi)

        val fragment1 = bottom_Fragment1()
        val fragment2 = bottom_Fragment2()
        val fragment3 = bottom_Fragment3()




        val home_homeToMain = Intent(this, MainActivity::class.java)


        val idPwShared = getSharedPreferences("idPw", MODE_PRIVATE)
        val idPwEditor = idPwShared.edit()
//@쉐어드 프리퍼렌스에서 데이터 지우기

        logoutBtn.setOnClickListener {
            idPwEditor.remove("id")
            idPwEditor.remove("pw")
            idPwEditor.apply()
            startActivity(home_homeToMain)
            //@finish로 액티비티의 활동을 끝내준다
            finish()
        }



        viewpagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpagerAdapter.fragments = listOf(
            fragment1,
            fragment2,
            fragment3
        )

        home_bottom_viewPager.adapter =viewpagerAdapter

        home_bottom_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                home_bottom_navi.menu.getItem(position).isChecked=true
            }
        })

        home_bottom_navi.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when(it.itemId){
                R.id.menu_bottom_first -> index = 0
                R.id.menu_bottom_second -> index =1
                R.id.menu_bottom_third -> index =2

            }
            home_bottom_viewPager.currentItem = index
            true
        }





    }
}
