package com.example.testapp.API.client

import com.example.testapp.API.service.MPTWorkService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MPTWorkClient {

    val urlMobile = "192.168.251.131"
    val urlHome = "192.168.0.56"

    val mptWorkService: MPTWorkService = Retrofit.Builder()
        .baseUrl("http://192.168.177.131:3000/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(MPTWorkService::class.java)
}