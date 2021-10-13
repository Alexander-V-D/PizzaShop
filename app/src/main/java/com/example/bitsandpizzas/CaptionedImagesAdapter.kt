package com.example.bitsandpizzas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class CaptionedImagesAdapter(captures: Array<String>, imageIds: Array<Int>):
    RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {
    val mCaptures = captures
    val mImageIds = imageIds
    interface Listener {
        fun onClick(position: Int)
    }
    lateinit var listener: Listener
    class ViewHolder(v: CardView) : RecyclerView.ViewHolder(v) {
        val cardView: CardView = v
    }
    override fun getItemCount(): Int {
        return mCaptures.size
    }
    fun setNewListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cv = LayoutInflater.from(parent.context).inflate(
            R.layout.card_captioned_image, parent, false)
        return ViewHolder(cv as CardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        val imageView = cardView.findViewById<ImageView>(R.id.image_info)
        val drawable = ContextCompat.getDrawable(cardView.context, mImageIds[position])
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = mCaptures[position]
        val textView = cardView.findViewById<TextView>(R.id.text_info)
        textView.text = mCaptures[position]
        cardView.setOnClickListener {
            listener.onClick(position)
        }
    }
}