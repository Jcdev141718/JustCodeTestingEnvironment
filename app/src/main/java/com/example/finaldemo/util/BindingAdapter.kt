package com.example.finaldemo.util

import android.graphics.Color
import androidx.cardview.widget.CardView
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

@BindingAdapter("changeCardColor")
fun CardView.changeColor(list: Int) {
    when (list) {
        in (0..25) -> {
            this.setBackgroundColor(Color.RED)
        }
        in (26..50) -> {
            this.setBackgroundColor(Color.BLUE)
        }
        in (51..75) -> {
            this.setBackgroundColor(Color.GREEN)
        }
        in (76..100) -> {
            this.setBackgroundColor(Color.YELLOW)
        }
    }
}