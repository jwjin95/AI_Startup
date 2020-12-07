package com.yonsei.aistartup.aigallery.model.network

import com.yonsei.aistartup.aigallery.model.data.ImageList
import com.yonsei.aistartup.aigallery.model.network.base.ApiLiveData
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageRetrofit {
    @GET("/list")
    fun getImageList(): ApiLiveData<ImageList>

    @GET("/list/{search}")
    fun getImageList(
        @Path("search") search: String
    ): ApiLiveData<ImageList>
}