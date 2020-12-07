package com.yonsei.aistartup.aigallery.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.yonsei.aistartup.aigallery.R
import com.yonsei.aistartup.aigallery.model.network.ImageRepository
import com.yonsei.aistartup.aigallery.model.network.base.ApiStatus
import kotlinx.android.synthetic.main.activity_main.*

class ImageListActivity : AppCompatActivity() {
    private val adapter by lazy { GridAdapter() }

    private val repository by lazy { ImageRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_main.layoutManager = GridLayoutManager(this, 2)
        recyclerview_main.adapter = adapter

        repository.getList().observe(this, Observer {
            when (it) {
                is ApiStatus.Success -> {
                    adapter.setData(it.data.list)
                }
            }
        })

    }

    fun onClick(v: View) {
        val chip = v as? Chip ?: return
        repository.search(chip.text.toString()).observe(this, Observer {
            when(it){
                is ApiStatus.Success -> {
                    adapter.setData(it.data.list)
                }
            }
        })
    }
}