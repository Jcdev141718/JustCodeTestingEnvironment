package com.example.finaldemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldemo.R
import com.example.finaldemo.databinding.ItemDemo1Binding
import com.example.finaldemo.model.PostsResponseItem

/**
 * Created by Abhin.
 */
class PostsAdapter(private var list: ArrayList<PostsResponseItem>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

private var postsData = mutableListOf<PostsResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setPostsList(movies: List<PostsResponseItem>) {
        this.postsData = movies.toMutableList()
        notifyDataSetChanged()
    }
    class PostsViewHolder(var binding: ItemDemo1Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(list: PostsResponseItem){
            binding.apply {
                postsData = list
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
       return PostsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R
           .layout.item_demo1,
           parent,false))
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val data = list[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}