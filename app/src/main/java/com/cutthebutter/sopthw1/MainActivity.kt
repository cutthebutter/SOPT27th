package com.cutthebutter.sopthw1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val signUpToLoginRequest = 1

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //@과거에는 Kotlin extension을 사용했으나 런타임 문제때문에 4.01 버전에서 없어지고 findViewByID로 변경
        val signBtn =findViewById<Button>(R.id.signBtn)
        val loginBtn =findViewById<Button>(R.id.loginBtn)
        val editLoginID = findViewById<EditText>(R.id.editLoginId)
        val editLoginPW =  findViewById<EditText>(R.id.editLoginPW)


        //@intent : 액티비티간 이동 :Intent(context, 이동할 액티비티 이름::class.java)
        val main_mainToSign = Intent(this, SignUpActivity::class.java)
        val main_mainToHome = Intent(this, HomeActivity::class.java)

        //@sharedPregerence를 사용하기 위함
        //@ val 쉐프이름 = getSharedPreferences("저장소명", MODE_PRIVATE)
       //@ 쉐프 내부 데이터  CRUD를 위해 에디터를 저장해 줌
        //@ val 쉐프에디터이름 = 쉐프이름.edit()
        //원래 돌아가지 않았는데 Context를 넣으니까 main으로 돌아온다
        val idPwShared = getSharedPreferences("idPw", Context.MODE_PRIVATE)
        val idPwEditor = idPwShared.edit()

        //아이디와 PW가 들어가 있으면 자동로그인이 되게끔하기
        //@쉐프에서 데이터 가져오기 : 쉐프이름.get자료형("key이름", "없을때 디폴트 값")
        if(idPwShared.getString("id","")!="" && idPwShared.getString("pw","")!=""){
            Toast.makeText(this, "자동로그인이 되었습니다.", Toast.LENGTH_SHORT).show()
            startActivity(main_mainToHome)
        }

//        val signUpToLoginRequest = 1;


        //버튼을 눌러 SignUpActivity로 이동
        signBtn.setOnClickListener {
            //@액티비티를 이동 시 startActivity(이동 인텐트 변수)
//            startActivity(main_mainToSign)
            startActivityForResult(main_mainToSign,signUpToLoginRequest)
        }
        //logiBtn을 누를 때 아이디와 PW의 데이터를 쉐어드 프리퍼런스에 저장함
        loginBtn.setOnClickListener {
            if(editLoginID.text.toString()!=""
                    && editLoginPW.text.toString()!=""){
                //@쉐프 안에 데이터를 저장할때 :
                //@쉐프에디터.put자료형("key이름",넣을 데이터
                idPwEditor.putString("id",editLoginID.text.toString())
                idPwEditor.putString("pw",editLoginPW.text.toString())
                //결과값을 t/f로 반환해야 한다면 commit을 사용하는데 그냥 apply를 사용하는게 나음
                idPwEditor.apply()
                Toast.makeText(this, "로그인이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                startActivity(main_mainToHome)
            }
            else{
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

    }



    //@다른 뷰에서 인텐트와 함께 데이터를 보내어 이동해 왔을 때 OnActivityResult 사용
    //@startActivityForResult()도 있지만 Activity Result API(OnActivityResult)를 사용하는 것이 더 좋다

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val editLoginID = findViewById<EditText>(R.id.editLoginId)
        val editLoginPw = findViewById<EditText>(R.id.editLoginPW)
//        val signUpToLoginRequest = 1;
        //액티비티가 정상적으로 종료 되었을 경우
        if(requestCode == 1){
            //MainActivity에서 호출한 경우에만 처리함
            if(resultCode== RESULT_OK){
                //받아온 이름과 전화번호를 MainActivity에 표시함
                //@이때 data는 null이 아니여야 하니 강제로 notNull처리를 해줘야 한다 :변수!!
                // *여기 왜 노랑이냐..? : !! 보다 ?.가 더 안정적임
                editLoginID.setText(data?.getStringExtra("id").toString())
                editLoginPw.setText(data?.getStringExtra("pw").toString())
            }
        }
    }
}