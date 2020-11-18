package com.cutthebutter.sopthw1
//ViewHolder: Adapter에서 전달받은 데이터를 layout에 Bind 시켜주는 역할 >>itemlayout에 넣어주는 역할

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//@ ProfileViewHolder 클래스를 선언하고 View타입의 생성자를 받음
//@ ProfileViewHolder 클래스는 RecyclerView.ViewHolder를 상속받은 후 View타입을 생성자로 넣어줌

//@코틀린 Class에서의 : -> 상속 / 코틀린 함수에서  : -> 반환
//@item 레이아웃에서 정의한 View/ViewGroup등을 요소로 가진다

class ProfileViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    private val listTitle : TextView = itemView.findViewById(R.id.listTitle)
    private val listSubTitle : TextView = itemView.findViewById(R.id.listSubTitle)
//    private val detTitle : TextView = itemView.findViewById(R.id.detProfileTitle)
//    private val detSubtitle : TextView = itemView.findViewById(R.id.detProfileSubtitle)
//    private val detMemo : TextView = itemView.findViewById(R.id.detProfileMemo)
//    private val detDate : TextView = itemView.findViewById(R.id.detProfileDate)

//@뷰의 요소에 실질적으로 데이터를 넣어주는 함수 : Adapter에서 해당 함수를 호출할 예정
    fun onBind(data: ProfileData){
        Log.d("Test","onBind 호출")
        listTitle.text = data.title
        listSubTitle.text = data.subTitle
//        detTitle.text = data.title
//        detSubtitle.text = data.subTitle
//        detMemo.text = data.memo
//        detDate.text = data.date


    }
}