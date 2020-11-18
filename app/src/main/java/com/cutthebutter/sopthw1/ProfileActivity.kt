package com.cutthebutter.sopthw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileActivity : AppCompatActivity() {
    //앞서 만든 Adapter를 lateinit으로 선언
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //Adatper에 컨텍스트 객체 파라미터로 전달
        val ProfileAdapter = ProfileAdapter(this)

        // 리사이클러뷰를 적용할 뷰
        val profile_rcv=findViewById<RecyclerView>(R.id.profileListRCV)

        //Recyclerview의 adapter를 방금 만든 프로필어댑터로 세팅
        profile_rcv.adapter=ProfileAdapter

//        val gToLSwitch = findViewById<Switch>(R.id.gToLSwitch)
//        gToLSwitch.setOnCheckedChangeListener{ buttonView, isChecked ->
//            if(isChecked){
//
//                } else {
//                profile_rcv.layoutManager=LinearLayoutManager(this)
//
//            }
//        }

        //리사이클러뷰의 배치방향을 LayoutManager로 설정 : 세로 방향인 LinearLayout으로 지정
        profile_rcv.layoutManager=LinearLayoutManager(this)

        //ProfileAdapter에 리스트로 보여줄 데이터를 넣어줌
        ProfileAdapter.data= mutableListOf(
            ProfileData("이름","이세민"
                ,"전주이씨 19대손이다","20/11/18"
            ),
            ProfileData("나이","22",
                "1999년 출생으로 만나이로는 20살이다. 영원히 스무살 이고 싶다.","20/11/18"
            ),
            ProfileData("파트","안드로이드"
                ,"개발에 집중하고자 안드로이드에 들어왔다.","20/11/18"
            ),
            ProfileData("좋아하는 색깔","노랑",
                "노랑색 옷을 입으면 잘어울려서 좋아한다", "20/11/18"
            ),
            ProfileData("오늘 먹고싶은 음식","마라탕",
            "마유의 그 얼얼한 맛이 좋다","20/11/18"
            ),
            ProfileData("오늘의 기분","개발 개빡치지만 재밌어"
                ,"진짜 개발 안되고 오류나고 근데 왜 오류난지도 모르겠고 어디서부터 고쳐야 할지 잘 모르겠게는데 되면 아드레날린 폭발하면서 재밌다",
            "20/11/18"
            ),
            ProfileData("장래희망","건물주",
                "진짜 건물주 만큼 신나는 장래희망이 또 있을까",
            "20/11/18"
            ),
            ProfileData("하고 싶은 것","경제적자유",
                "경제적 자유를 가진 후 내 마음 가는데로 도전하는 삶을 살고 싶다",
            "20/11/18"
            ),
            ProfileData("나의 장점","실행력, 친화력",
                " 진짜 내 장점이다", "20/11/16"
            ),
            ProfileData("나의 단점","끈기, 계획력",
                "그래서 J형인간이 되고자 노력중이다", "20/11/16"
            )

                )
        ProfileAdapter.notifyDataSetChanged() //Adater에 데이터가 갱신되었다고 알려주기
        // 클릭리스너를 등록

        ProfileAdapter.setItemClickListner(object : ProfileAdapter.ItemClickListener{
            override fun onClick(view: View, position :Int){
                Log.d("SSS","${position}번 리스트 선택")
            }
        })

//        val list_listToGrid= Intent(this, ProfileGridActivity::class.java)
//        val ListToGridBtn = findViewById<Button>(R.id.lToGSwitch)
//
//        ListToGridBtn.setOnClickListener {
//            startActivity(list_listToGrid)
//            finish()
//        }


    }
}