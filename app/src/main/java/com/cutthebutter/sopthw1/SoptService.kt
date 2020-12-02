package com.cutthebutter.sopthw1

import com.cutthebutter.sopthw1.Data.RequestLoginData
import com.cutthebutter.sopthw1.Data.RequestSignupData
import com.cutthebutter.sopthw1.Data.ResponseLoginData
import com.cutthebutter.sopthw1.Data.ResponseSignupData


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import java.net.ResponseCache

interface SoptService {

    @Headers("Content-Type:application/json")
    @POST("users/signin")

    fun postLogin(
        @Body body : RequestLoginData
    ) : Call<ResponseLoginData>

}