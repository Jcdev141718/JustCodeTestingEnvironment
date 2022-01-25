package com.example.finaldemo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldemo.R
import com.example.finaldemo.databinding.ImgTxtDemo3Binding
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem

/**
 * Created by Abhin.
 */
class ImgTxtAdapter(private var imgTxtList: ArrayList<ImgTxtResponseItem>) :
    RecyclerView.Adapter<ImgTxtAdapter.ImgTxtViewHolder>() {

    inner class ImgTxtViewHolder(private var mBinding: ImgTxtDemo3Binding) : RecyclerView.ViewHolder
        (mBinding.root) {
        fun bindData(list: ImgTxtResponseItem) {
            mBinding.apply {
                imgTxtData = list
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImgTxtAdapter.ImgTxtViewHolder {
        return ImgTxtViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R
                    .layout.item_demo3,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImgTxtAdapter.ImgTxtViewHolder, position: Int) {
        val data = imgTxtList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return imgTxtList.size
    }
}