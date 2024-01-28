package com.ayoolamasha.uidesignassignment.core

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.ayoolamasha.uidesignassignment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("app:loadImage")
fun loadImage(image: ImageView?, imageString: Int?) {
    if (image != null) {
        Glide.with(image.context)
            .load(imageString)
            .apply(RequestOptions())
            .centerCrop()
            .into(image)
    }
}

@BindingAdapter("app:shipmentStatus")
fun shipmentStatus(textView: TextView, text: Int){
    when(text){
        R.string.in_progress ->{
            textView.text = text.toString()
            textView.setTextColor(Color.parseColor("#8fddba"))
        }

        R.string.pending ->{
            textView.text = text.toString()
            textView.setTextColor(Color.parseColor("#efc7a4"))
        }

        R.string.loading ->{
            textView.text = text.toString()
            textView.setTextColor(Color.parseColor("#b4dafb"))
        }
    }
}