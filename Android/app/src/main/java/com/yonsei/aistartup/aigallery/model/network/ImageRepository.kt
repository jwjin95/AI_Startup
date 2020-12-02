package com.yonsei.aistartup.aigallery.model.network

import com.yonsei.aistartup.aigallery.model.data.ImageData
import com.yonsei.aistartup.aigallery.model.data.ImageList
import com.yonsei.aistartup.aigallery.model.network.base.ApiLiveData
import com.yonsei.aistartup.aigallery.model.network.base.RestClient

class ImageRepository {
    private val service = RestClient.getImageService()
    fun getList() : ApiLiveData<ImageList> = service.getImageList()

}