package com.yonsei.aistartup.aigallery.ui.gallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yonsei.aistartup.aigallery.R
import com.yonsei.aistartup.aigallery.model.data.ImageData
import com.yonsei.aistartup.aigallery.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_grid_card.*

class GridAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private var list: List<ImageData>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_card, parent, false)

        return GridViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is GridViewHolder ->{
                Glide.with(holder.imageview_grid)
                    .load(list!![position].url)
                    .into(holder.imageview_grid)
                holder.imageview_grid.setImageResource(R.drawable.img_jack_honey)
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    fun setData(data: List<ImageData>) {
        this.list = data
        notifyDataSetChanged()
    }

    class GridViewHolder(v: View) : BaseViewHolder(v)
}