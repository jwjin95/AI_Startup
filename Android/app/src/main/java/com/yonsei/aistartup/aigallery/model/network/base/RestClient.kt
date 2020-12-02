package com.yonsei.aistartup.aigallery.model.network.base

import com.yonsei.aistartup.aigallery.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private val retrofit =
        Retrofit.Builder().run {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }

            val client = OkHttpClient.Builder().run {
                addInterceptor(loggingInterceptor)
                build()
            }

//            baseUrl("http://192.168.0.9:3000") // 도메인 주소
            baseUrl("3.35.139.156:8000/") // 도메인 주소
            client(client)

            addCallAdapterFactory(LiveDataCallAdapter.Factory())
            addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
            build()
        }
}

