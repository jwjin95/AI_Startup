package com.yonsei.aistartup.aigallery.model

data class ImageData(
    val id: Int
) {
    companion object {
        fun getSample() = ImageData(
            0
        )

        fun getSampleList(): List<ImageData> = listOf(
            getSample(),
            getSample(),
            getSample(),
            getSample()
        )
    }
}