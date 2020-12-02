package com.cutthebutter.sopthw1.Data

import com.cutthebutter.sopthw1.SoptServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class RequestLoginData(
    val email : String,
    val password : String
)

//val call : Call<ResponseLoginData> = SoptServiceImpl.service.postLogin(
//    RequestLoginData(email = RequestLoginData.email, password = password)
//)
//
//call.enqueue(object : Callback<ResponseLoginData> {
//    override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
//        //통신 실패 로직
//    }
//
//    override fun onResponse(call: Call<ResponseLoginData>, response: Response<ResponseLoginData>) {
//        response.takeIf { it.isSuccessful }
//            ?.body()
//            ?.let{
//                    it ->
//                //do somting
//            }? : showError(response.errorBody())
//    }
//})