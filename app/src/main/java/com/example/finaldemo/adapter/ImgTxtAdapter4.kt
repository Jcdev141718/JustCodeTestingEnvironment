package com.example.finaldemo.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
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
                edtItem4.addTextChangedListener(object : TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        Log.d("BeforeChange", "beforeTextChanged: $p0 $p1 $p2 $p3")
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        val no1 = if (edtItem4.text.isNullOrEmpty()) "0" else edtItem4.text.toString()

                        if (edtItem4.text!!.isNotEmpty()){
                            when (Integer.parseInt(no1)) {
                                in 0..25 -> {
                                    cardViewItem4.setBackgroundColor(Color.RED)
                                }
                                in 25..50 -> {
                                    cardViewItem4.setBackgroundColor(Color.BLUE)
                                }
                                in 51..75 -> {
                                    cardViewItem4.setBackgroundColor(Color.GREEN)
                                }
                                in 76..100 -> {
                                    cardViewItem4.setBackgroundColor(Color.YELLOW)
                                }
                                else -> {
                                    cardViewItem4.setBackgroundColor(Color.WHITE)
                                }
                            }
                        }
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        Log.d("AfterChange", "afterTextChanged: ")
                    }

                })
                btnPlus.setOnClickListener {
                    val no1 = if (edtItem4.text.isNullOrEmpty()) "0" else edtItem4.text.toString()
                    mClickedInterface.clickButton(position = position,no1.toInt(), null)
                }
                btnMinus.setOnClickListener {
                    val no1 = if (edtItem4.text.isNullOrEmpty()) "0" else edtItem4.text.toString()
                    mClickedInterface.clickButton(position = position,null,no1.toInt())
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