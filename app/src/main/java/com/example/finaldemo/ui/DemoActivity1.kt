package com.example.finaldemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.PostsAdapter
import com.example.finaldemo.databinding.ActivityDemo1Binding
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.repository.PostsRepository
import com.example.finaldemo.viewmodel.MyViewModelFactory
import com.example.finaldemo.viewmodel.PostsViewModel

class DemoActivity1 : AppCompatActivity() {
    lateinit var mBinding : ActivityDemo1Binding
    lateinit var postsViewModel: PostsViewModel
    lateinit var mAdapter: PostsAdapter
    private var apiService = ApiService.getRetrofit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDemo1Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        postsViewModel = ViewModelProvider(this, MyViewModelFactory(PostsRepository(apiService)))[PostsViewModel::class.java]
        postsViewModel.getPosts()
        postsViewModel.postList.observe(this,{
            mAdapter.setPostsList(it)
        })
        mBinding.rvDemo1.layoutManager = LinearLayoutManager(this)
        mAdapter = PostsAdapter()
        mBinding.rvDemo1.adapter = mAdapter
    }
}