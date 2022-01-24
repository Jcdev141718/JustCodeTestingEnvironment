package com.example.finaldemo.util

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

/**
 * Created by Abhin.
 */

@BindingAdapter("loadImg")
fun ShapeableImageView.imgFromUrl(url: String) {
    Glide.with(context).load(url).into(this)
}