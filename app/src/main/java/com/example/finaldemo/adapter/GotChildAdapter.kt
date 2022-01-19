package com.example.finaldemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldemo.R
import com.example.finaldemo.databinding.ChildDemo2Binding
import com.example.finaldemo.model.got.Member

/**
 * Created by Abhin.
 */
class GotChildAdapter(var gotChildItem: List<Member>) : RecyclerView.Adapter<GotChildAdapter.ChildViewHolder>() {

    class ChildViewHolder(var binding: ChildDemo2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(list: Member) {
            binding.apply {
                childGotData = list
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R
                    .layout.item_nestetdemo2,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val data = gotChildItem[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return gotChildItem.size
    }
}