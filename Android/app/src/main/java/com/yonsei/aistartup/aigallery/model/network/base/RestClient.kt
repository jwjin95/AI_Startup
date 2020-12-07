package com.yonsei.aistartup.aigallery.model.network.base

import com.yonsei.aistartup.aigallery.BuildConfig
import com.yonsei.aistartup.aigallery.model.network.ImageRepository
import com.yonsei.aistartup.aigallery.model.network.ImageRetrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    fun getImageService(): ImageRetrofit = retrofit.create(ImageRetrofit::class.java)

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

            baseUrl("http://aistarup-01-dev.ap-northeast-2.elasticbeanstalk.com") // 도메인 주소
            client(client)

            addCallAdapterFactory(LiveDataCallAdapter.Factory())
            addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
            build()
        }
}

