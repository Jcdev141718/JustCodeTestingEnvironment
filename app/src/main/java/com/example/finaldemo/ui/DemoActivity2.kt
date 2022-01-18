package com.example.finaldemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.Demo2Adapter
import com.example.finaldemo.databinding.ActivityDemo2Binding
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.repository.PostsRepository
import com.example.finaldemo.viewmodel.MyViewModelFactory
import com.example.finaldemo.viewmodel.PostsViewModel

class DemoActivity2 : AppCompatActivity() {
    lateinit var mBinding: ActivityDemo2Binding
    lateinit var postsViewModel: PostsViewModel
    lateinit var mAdapter: Demo2Adapter
    private var apiService = ApiService.getRetrofit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDemo2Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        postsViewModel = ViewModelProvider(this, MyViewModelFactory(PostsRepository(apiService)))[PostsViewModel::class.java]
        postsViewModel.getPosts()
        postsViewModel.postList.observe(this,{
            mAdapter.setPostsList(it)
        })
        mBinding.rvDemo2.layoutManager = LinearLayoutManager(this)
        mAdapter = Demo2Adapter()
        mBinding.rvDemo2.adapter = mAdapter
    }
}