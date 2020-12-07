package com.yonsei.aistartup.aigallery.model.data

import com.google.gson.annotations.SerializedName

data class ImageList (
    @SerializedName("image_info") val list : List<ImageData>
)