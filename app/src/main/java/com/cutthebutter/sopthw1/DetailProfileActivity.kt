package com.cutthebutter.sopthw1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class DetailProfileActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profile)

        val title = findViewById<TextView>(R.id.detProfileTitle)
        val subTitle = findViewById<TextView>(R.id.detProfileSubtitle)
        val memo = findViewById<TextView>(R.id.detProfileMemo)
        val date = findViewById<TextView>(R.id.detProfileDate)


//
        title.text = intent.getStringExtra("title")
        subTitle.text = intent.getStringExtra("subTitle")
        memo.text = intent.getStringExtra("memo")
        date.text = intent.getStringExtra("date")




    }
}