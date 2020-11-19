package com.cutthebutter.sopthw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detProfileTitle = findViewById<TextView>(R.id.detProfileTitle)
        val detProfileSubtitle = findViewById<TextView>(R.id.detProfileSubtitle)
        val detProfileMemo = findViewById<TextView>(R.id.detProfileMemo)
        val detProfileDate = findViewById<TextView>(R.id.detProfileDate)

        detProfileTitle.text=intent.getStringExtra("title")
        detProfileSubtitle.text=intent.getStringExtra("subtitle")
        detProfileMemo.text=intent.getStringExtra("memo")
        detProfileDate.text=intent.getStringExtra("date")


//        detProfileTitle.text = intent.getStringExtra("title")
//        detProfileSubtitle.text = intent.getStringExtra("subtitle")
//        if(detProfileTitle.text == "이름") {
//            detProfileMemo.text = "2020.11.19"
//            detProfileDate.text = "전주 이씨 19대손이다"
//        }
//        else if(detProfileTitle.text == "나이") {
//            detProfileMemo.text = "2020.11.20"
//            detProfileDate.text = "만으로는 20살이다 영워히 20살 하고 싶다"
//        }
//        else if(detProfileTitle.text == "파트") {
//            detProfileMemo.text = "2020.11.21"
//            detProfileDate.text = "개발에 집중하고자 안드로이드로 들어왔다."
//        }
//        else if(detProfileTitle.text == "좋아하는 색깔") {
//            detProfileMemo.text = "2020.11.22"
//            detProfileDate.text = "노란 옷이 얼굴에 잘 받아 좋아한다"
//        }
//        else if(detProfileTitle.text == "좋아하는 음식") {
//            detProfileMemo.text = "2020.11.23"
//            detProfileDate.text = "마라탕...마라탕이 최고다"
//        }
//        else if(detProfileTitle.text == "Sopt") {
//            detProfileMemo.text = "2020.11.24"
//            detProfileDate.text = "이런 좋은 동아리 좀더 어릴 때 들어올걸 그랬다"
//        }
    }
    }
