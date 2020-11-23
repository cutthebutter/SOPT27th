package com.cutthebutter.sopthw1.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cutthebutter.sopthw1.ItemTouch.ItemTouchHelperCallback
import com.cutthebutter.sopthw1.R
import com.cutthebutter.sopthw1.Recycler.DetailActivity
import com.cutthebutter.sopthw1.Recycler.ProfileAdapter
import com.cutthebutter.sopthw1.Recycler.ProfileData


class bottom_Fragment2 : Fragment() {
    private lateinit var profileAdapter: ProfileAdapter

    var name = "default"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_2, container, false)
//        val textView = view.findViewById<TextView>(R.id.fragment2)
//        textView.text = name

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        profileAdapter = ProfileAdapter(view.context) //this = RecyclerViewActivity

        val profileRcv = view?.findViewById<RecyclerView>(R.id.profileRcv)
        val changeSwitch = view?.findViewById<Switch>(R.id.changeSwitch)



        profileAdapter.itemClick = object : ProfileAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val item = profileAdapter.data[position]
                val intent = Intent(view.context, DetailActivity::class.java)

                intent.putExtra("title", item.title)
                intent.putExtra("subtitle", item.subTitle)
                intent.putExtra("memo", item.memo)
                intent.putExtra("date", item.date)

                startActivity(intent)
            }
        }

        val itemTouchHelperCallback = ItemTouchHelperCallback(profileAdapter)
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(profileRcv)

        profileAdapter.setItemViewType(0);
        profileRcv.adapter = profileAdapter
        profileRcv.layoutManager = LinearLayoutManager(view.context)

        changeSwitch.setOnCheckedChangeListener { CompoundButton, onSwitch ->
            //  스위치가 켜지면
            if (onSwitch) {
                profileAdapter.setItemViewType(1)
                profileRcv.adapter = profileAdapter
                profileRcv.layoutManager = GridLayoutManager(view.context, 2)
            }
            //  스위치가 꺼지면
            else {
                profileAdapter.setItemViewType(0);
                profileRcv.adapter = profileAdapter
                profileRcv.layoutManager = LinearLayoutManager(view.context)
            }
        }

        profileAdapter.data = mutableListOf(
            ProfileData("이름", "이세민", "전주 이씨 19대손이다", "2020.11.19"),
            ProfileData("나이", "22", "만으로는 20살이다. 영원히 20살 하고 싶다", "2020.11.20"),
            ProfileData("파트", "안드로이드", "개발에 집중하고자 안드로이드로 들어왔다.", "2020.11.21"),
            ProfileData("좋아하는 색깔", "노란색", "노란 옷이 얼굴에 잘 받아 좋아한다", "2020.11.22"),
            ProfileData("좋아하는 음식", "마라탕", "마라탕...마라탕이 최고다", "2020.11.23"),
            ProfileData("Sopt", "27기", "이런 좋은 동아리 좀더 어릴 때 들어올걸 그랬다", "2020.11.24")
        )
        profileAdapter.notifyDataSetChanged()


    }
}
