package com.example.finaldemo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldemo.R
import com.example.finaldemo.databinding.ParentDemo2Binding
import com.example.finaldemo.model.got.GotResponseItem

/**
 * Created by Abhin.
 */
class GotParentAdapter(var context: Context) :
    RecyclerView.Adapter<GotParentAdapter.ParentViewHolder>() {

    private var viewPools = RecyclerView.RecycledViewPool()

    private var gotData = mutableListOf<GotResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setGotList(gotItem: List<GotResponseItem>) {
        gotData.addAll(gotItem)
        notifyDataSetChanged()
    }

    class ParentViewHolder(var binding: ParentDemo2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(list: GotResponseItem) {
            binding.apply {
                gotData = list
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R
                    .layout.item_demo2,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val data = gotData[position]
        holder.binding.rvNestedDemo2.setRecycledViewPool(viewPools)
        holder.binding.rvNestedDemo2.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL, false
        )
        holder.binding.rvNestedDemo2.adapter = GotChildAdapter(data.members)
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return gotData.size
    }
}