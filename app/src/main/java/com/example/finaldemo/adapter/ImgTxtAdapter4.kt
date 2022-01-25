package com.example.finaldemo.adapter

import android.annotation.SuppressLint
import android.util.Log
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
class ImgTxtAdapter4(private var imgTxtList: ArrayList<ImgTxtResponseItem>, var mClickedInterface: ButtonClickInterface) : RecyclerView.Adapter<ImgTxtAdapter4.ImgTxtViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(modelList:ArrayList<ImgTxtResponseItem>){
        imgTxtList= ArrayList()
        imgTxtList.addAll(modelList)
        notifyDataSetChanged()
    }

    inner class ImgTxtViewHolder(private var mBinding: ImgTxtDemo4Binding) : RecyclerView.ViewHolder
        (mBinding.root) {
        fun bindData(list: ImgTxtResponseItem, position: Int) {
            mBinding.apply {
                imgTxtData4 = list
                Log.d("ImgTxtViewHolder", " bindData: ${list.progress}")
                executePendingBindings()
                btnPlus.setOnClickListener {
                    mClickedInterface.clickButton(position = position,edtItem4.text.toString().toInt(), null)
                }
                btnMinus.setOnClickListener {
                    mClickedInterface.clickButton(position = position,null,edtItem4.text.toString().toInt())
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImgTxtViewHolder {
        return ImgTxtViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R
                    .layout.item_demo4,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImgTxtViewHolder, position: Int) {
        val data = imgTxtList[position]
        holder.bindData(data,position)
    }

    override fun getItemCount(): Int {
        return imgTxtList.size
    }

    interface ButtonClickInterface {
        fun clickButton(position: Int, plus : Int?, minus : Int?)
    }
}