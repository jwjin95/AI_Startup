package com.yonsei.aistartup.aigallery.model.data

import com.google.gson.annotations.SerializedName

data class ImageData(
    @SerializedName("URL") val url: String
)