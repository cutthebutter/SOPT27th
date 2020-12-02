package com.cutthebutter.sopthw1


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//싱글톤으로 만드는 실제 구현체 : 객체는 하나만 생성하고 프로젝트 어디서나 사용할 수 있게 하는 디자인 패턴 중 하나

//싱글톤 객체로 사용하기 위해 object로 선언
object SoptServiceImpl {
    // 메인 서버 URL 변수 BASE_URL
    private const val BASE_URL = "http://15.164.83.210:3000/"
    //retrofit 객체 선언
    private val retrofit : Retrofit = Retrofit.Builder()//Retrofit.Builder(): 레트로핏 빌더 생성(생성자 호출)
        .baseUrl(BASE_URL)//빌더 객체의 BASE_URL 호출. 서버의 메인 URL 전달
        .addConverterFactory(GsonConverterFactory.create()) //gson 연동
        .build()//Retrofit 객체 반환

    val service : SoptService = retrofit.create(SoptService::class.java)
    val signup : SoptServiceUp = retrofit.create(SoptServiceUp::class.java)//Interface 객체를 넘겨 실제 구현체 생성
}

