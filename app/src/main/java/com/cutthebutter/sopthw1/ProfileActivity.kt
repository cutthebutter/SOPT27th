package com.cutthebutter.sopthw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileActivity : AppCompatActivity() {
    private lateinit var ProfileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ProfileAdapter = ProfileAdapter(this)

        val profileRcv =findViewById<RecyclerView>(R.id.profileRcv)
        val changeSwitch = findViewById<Switch>(R.id.changeSwitch)

        ProfileAdapter.itemClick = object: ProfileAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {


                val item = ProfileAdapter.data[position]
                val intent = Intent(view.context, DetailActivity::class.java)

                intent.putExtra("title", item.title)
                intent.putExtra("subtitle",item.subTitle)
                intent.putExtra("memo", item.memo)
                intent.putExtra("date",item.date)
                setResult(1003, intent)
                startActivity(intent)
            }
        }

        val itemTouchHelperCallback = ItemTouchHelperCallback(ProfileAdapter)
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(profileRcv)

        ProfileAdapter.setItemViewType(0);
        profileRcv.adapter = ProfileAdapter
        profileRcv.layoutManager = LinearLayoutManager(this)

        changeSwitch.setOnCheckedChangeListener{CompoundButton, onSwitch ->
            //  스위치가 켜지면
            if (onSwitch){
                ProfileAdapter.setItemViewType(1)
                profileRcv.adapter = ProfileAdapter
                profileRcv.layoutManager = GridLayoutManager(this, 2)
            }
            //  스위치가 꺼지면
            else{
                ProfileAdapter.setItemViewType(0);
                profileRcv.adapter = ProfileAdapter
                profileRcv.layoutManager = LinearLayoutManager(this)
            }
        }

        ProfileAdapter.data = mutableListOf(
                ProfileData("이름", "이세민","전주 이씨 19대손이다", "2020.11.19" ),
                ProfileData("나이", "22", "만으로는 20살이다. 영원히 20살 하고 싶다", "2020.11.20"),
                ProfileData("파트", "안드로이드", "개발에 집중하고자 안드로이드로 들어왔다.","2020.11.21" ),
                ProfileData("좋아하는 색깔", "노란색", "노란 옷이 얼굴에 잘 받아 좋아한다", "2020.11.22"),
                ProfileData("좋아하는 음식", "마라탕", "마라탕...마라탕이 최고다", "2020.11.23"),
                ProfileData("Sopt", "27기", "이런 좋은 동아리 좀더 어릴 때 들어올걸 그랬다", "2020.11.24")
        )
        ProfileAdapter.notifyDataSetChanged()


    }
}
