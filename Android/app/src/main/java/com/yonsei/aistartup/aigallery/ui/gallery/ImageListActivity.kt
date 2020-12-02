package com.yonsei.aistartup.aigallery.ui.gallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yonsei.aistartup.aigallery.R
import com.yonsei.aistartup.aigallery.model.ImageData
import kotlinx.android.synthetic.main.activity_main.*

class ImageListActivity : AppCompatActivity() {
    private val adapter by lazy{
        GridAdapter().apply {
            setData(ImageData.getSampleList())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_main.layoutManager = GridLayoutManager(this, 2)
        recyclerview_main.adapter = adapter
    }
}