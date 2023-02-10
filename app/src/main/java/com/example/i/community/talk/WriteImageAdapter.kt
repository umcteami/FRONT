package com.example.i.community.talk

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.R

class WriteImageAdapter() : RecyclerView.Adapter<WriteImageAdapter.ViewHolder>(){
    lateinit var imageList : ArrayList<Uri>
    lateinit var context : Context

    constructor(imageList:ArrayList<Uri>, context: Context):this(){
        this.imageList = imageList
        this.context = context
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val galleryView : ImageView = view.findViewById(R.id.galleryView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.item_image_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(imageList[position])
            .into(holder.galleryView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}