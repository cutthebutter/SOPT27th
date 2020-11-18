package com.cutthebutter.sopthw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signDoneBtn=findViewById<Button>(R.id.signDone)
        val itemEditName =findViewById<EditText>(R.id.editsignName)
        // @코틀린에서 editText 값을 가져오려면 .text.toString()
//        val name=itemEditName.text.toString()
        val itemEditId =findViewById<EditText>(R.id.editsignID)
//        val id=itemEditId.text.toString()
        val itemEditPW =findViewById<EditText>(R.id.editSignPW)
//        val pw=itemEditPW.text.toString()
        val itemEditPwCheck =findViewById<EditText>(R.id.editsignPwCheck)
//        val pwcheck=itemEditPwCheck.text.toString()

//        val warningDifPw: View =findViewById<View>(R.id.warningDifPw)

        //mainActivity로 돌아가는 인텐트
        val sign_signToMain = Intent(this, MainActivity::class.java)


//비밀번호 동질 확인
//어떻게 할 수 있을까
//         if(!itemEditPW.text.toString().equals(itemEditPwCheck.text.toString())) {
//             warningDifPw.visibility = VISIBLE
//         }



// 폼이 다 입력되었는지 확인 후 회원가입 처리
        signDoneBtn.setOnClickListener {
            if(itemEditName.text.toString() !=""
                    && itemEditId.text.toString() !=""
                    && itemEditPW.text.toString() !=""
                    && itemEditPwCheck.text.toString() !=""){
                Toast.makeText(this, itemEditName.text.toString() + "님, 가입을 환영합니다",
                        Toast.LENGTH_SHORT).show()
                // @액티비티 간 데이터를 주고 받으려면 인덴트에 데이터를 넣어 보낸다
                // :이동intent변수.putExtra(key, data) 메서드 사용
                sign_signToMain.putExtra("id",itemEditId.text.toString())
                sign_signToMain.putExtra("pw", itemEditPW.text.toString())
//연주언니는 왜 Activity.Result_OK로 했을까? : 상관없다고 한다
                //@intent에 데이터를 넣어서 보내려면 activitiy를 이동할 때 setResult(RESILT_OK, 인텐트 명)
                //@이후 종료를 원하기 때문에 finish()
                setResult(RESULT_OK,sign_signToMain)
                finish()
                //@intent와 함께 넘겨주는 데이터가 없으면 activity를 이동할 때 StartActivity(intent 명을 씀)
                //@다른 액티비티에서 실행해 액션의 결과값을 받아야 한다면 startActivity가 아닌 -
                //startActivityFoResult()와 setResult(), onActivityResult() 함수를 사용함 -
                //1.액티비티A에서 액티비티B를 호출 : intent와 (1) requestCode를 추가해서 보냄 -
                //requestCode는 나중에 액티비티 B->액티비티 A로 응답 송달 시,요청의 종류를 구분하기 위해 사용 : 정수로 구성
                //2.액티비티 B에서 액티비티 A에게 결과 리턴 : setResult 함수를 사용, resultCode와 intent 포함 -
                // : 이때 requestCode는 따로 세팅해주지 않아도 알아서 액티비티A에게 전달됨 -
                // -> 이후 finish()를 사용해 액티비티 B를 다시 호출함
                //3. 액티비티B로부터의 결과 분석 : 액티비티B로부터 결과를 받으면 onActivityResult()함수가 호출됨 -
                // 이때 requestCode, resultCode, Intent를 함께 받음
                // 코드 처리 로직 : 리퀘스트가 우리가 요청한 리퀘스트가 맞는지 확인(requestCod)
                // -> 리퀘스트가 성공적인지 확인(resultCode) -> intentData 처리
//                startActivity(sign_signToMain)
            }else{
                Toast.makeText(this, "빈 칸이 있습니다. 모두 작성 바랍니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}