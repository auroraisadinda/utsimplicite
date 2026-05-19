package com.example.mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val imageList:ArrayList<Image>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    var onItemClick : ((Image) -> Unit)? = null

    class ImageViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        val imageView : ImageView =
            itemView.findViewById(R.id.imgItem)

        val imageTitle : TextView =
            itemView.findViewById(R.id.txtTitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image,parent,false)

        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(
        holder: ImageViewHolder,
        position: Int
    ) {

        val image = imageList[position]

        holder.imageView.setImageResource(image.imageSource)
        holder.imageTitle.text = image.imageTitle

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(image)
        }
    }
}