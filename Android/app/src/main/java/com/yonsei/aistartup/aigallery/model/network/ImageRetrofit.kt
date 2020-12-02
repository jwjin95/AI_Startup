package com.yonsei.aistartup.aigallery.model.network

import com.yonsei.aistartup.aigallery.model.data.ImageData
import com.yonsei.aistartup.aigallery.model.data.ImageList
import com.yonsei.aistartup.aigallery.model.network.base.ApiLiveData
import retrofit2.http.GET

interface ImageRetrofit {
    @GET("/list")
    fun getImageList(): ApiLiveData<ImageList>
}