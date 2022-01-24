package com.example.finaldemo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldemo.R
import com.example.finaldemo.databinding.ImgTxtDemo4Binding
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem

/**
 * Created by Abhin.
 */
class ImgTxtAdapter4(private var imgTxtList: ArrayList<ImgTxtResponseItem>) :
    RecyclerView.Adapter<ImgTxtAdapter4.ImgTxtViewHolder>() {

    inner class ImgTxtViewHolder(private var mBinding: ImgTxtDemo4Binding) : RecyclerView.ViewHolder
        (mBinding.root) {
        fun bindData(list: ImgTxtResponseItem) {
            mBinding.apply {
                imgTxtData4 = list
                executePendingBindings()
                when {
                    edtItem4.text!!.equals(0..25) -> {
                        cardViewItem4.setBackgroundColor(Color.RED)
                    }
                    edtItem4.text!!.equals(26..50) -> {
                        cardViewItem4.setBackgroundColor(Color.BLUE)
                    }
                    edtItem4.text!!.equals(51..75) -> {
                        cardViewItem4.setBackgroundColor(Color.GREEN)
                    }
                    edtItem4.text!!.equals(76..100) -> {
                        cardViewItem4.setBackgroundColor(Color.YELLOW)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImgTxtAdapter4.ImgTxtViewHolder {
        return ImgTxtViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R
                    .layout.item_demo4,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImgTxtAdapter4.ImgTxtViewHolder, position: Int) {
        val data = imgTxtList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return imgTxtList.size
    }
}