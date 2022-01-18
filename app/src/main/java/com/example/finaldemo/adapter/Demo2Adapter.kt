package com.example.finaldemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldemo.R
import com.example.finaldemo.databinding.ItemDemo2Binding
import com.example.finaldemo.model.PostsResponseItem

/**
 * Created by Abhin.
 */
class Demo2Adapter : RecyclerView.Adapter<Demo2Adapter.Demo2ViewHolder>() {

    private var postsData = mutableListOf<PostsResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setPostsList(movies: List<PostsResponseItem>) {
        postsData.addAll(movies)
        notifyDataSetChanged()
    }

    class Demo2ViewHolder(var binding: ItemDemo2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(list: PostsResponseItem) {
            binding.apply {
                postsData2 = list
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Demo2ViewHolder {
        return Demo2ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R
                    .layout.item_demo2,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Demo2ViewHolder, position: Int) {
        val data = postsData[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return postsData.size
    }
}