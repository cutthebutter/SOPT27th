package com.cutthebutter.sopthw1.Data

import com.google.gson.annotations.SerializedName

data class ResponseSignupData(
    val data: Data,
//    val message: String,
    // 아래 어노테이션을 통해 Json 객체의 값과 대응시킬 수 있다.

    val status: Int,
    val success:Boolean,
    @SerializedName("message")
    val responseMessage:String,
){
    data class Data(
        val email : String,
        val password : String,
        val userName : String
    )
}