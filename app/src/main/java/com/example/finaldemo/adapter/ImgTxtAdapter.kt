package com.example.finaldemo.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finaldemo.R
import com.example.finaldemo.databinding.ImgTxtDemo3Binding
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem

/**
 * Created by Abhin.
 */
class ImgTxtAdapter(private var context: Context,private var imgTxtList :
ArrayList<ImgTxtResponseItem>) :
    RecyclerView
.Adapter<ImgTxtAdapter.ImgTxtViewHolder>(){

    inner class ImgTxtViewHolder(private var mBinding : ImgTxtDemo3Binding) : RecyclerView.ViewHolder
    (mBinding.root){
        fun bindData(list: ImgTxtResponseItem){
            mBinding.apply {
                imgTxtData = list
                executePendingBindings()
                Glide.with(context).load(list.image).into(imgItem3)
                progressItem3.progress = (0..100).random()
                when (progressItem3.progress) {
                    (0..25).random()-> {
                        cardViewItem3.setBackgroundColor(Color.CYAN)
                    }
                    (26..50).random() -> {
                        cardViewItem3.setBackgroundColor(Color.BLUE)
                    }
                    (51..75).random() -> {
                        cardViewItem3.setBackgroundColor(Color.GREEN)
                    }
                    else -> {
                        cardViewItem3.setBackgroundColor(Color.YELLOW)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgTxtViewHolder {
        return ImgTxtViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R
                    .layout.item_demo3,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImgTxtViewHolder, position: Int) {
        val data = imgTxtList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return imgTxtList.size
    }
}