package com.emsib.mvvmdemoapp.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class GlideBindingAdapter {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImageResource(imageView: ImageView, imageUrl: String?) {
            Glide
                .with(imageView.context)
                .load(imageUrl)
                .into(imageView)
        }
    }
}