package com.cutthebutter.sopthw1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
        val profileBtn =findViewById<Button>(R.id.ProfileBtn)

        val home_homeToMain = Intent(this, MainActivity::class.java)
        val home_homeToProfile =Intent(this, ProfileActivity::class.java)

        val idPwShared = getSharedPreferences("idPw", Context.MODE_PRIVATE)
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

        profileBtn.setOnClickListener {
            startActivity(home_homeToProfile)
        }
    }
}