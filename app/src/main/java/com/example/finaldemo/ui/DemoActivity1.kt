package com.example.finaldemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.PostsAdapter
import com.example.finaldemo.databinding.ActivityDemo1Binding
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.network.RetrofitHelper
import com.example.finaldemo.network.isInternetAvailable
import com.example.finaldemo.repository.PostsRepository
import com.example.finaldemo.room.AppDatabase
import com.example.finaldemo.viewmodel.PostsViewModel
import com.example.finaldemo.viewmodel.PostsViewModelFactory

class DemoActivity1 : AppCompatActivity() {
    private var binding: ActivityDemo1Binding? = null
    private var viewModel: PostsViewModel? = null
    private var mAdapter: PostsAdapter? = null
    private var apiService: ApiService? = null
    private var database : AppDatabase? = null
    private var repository : PostsRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemo1Binding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initVariable()
        initData()
        initObserver()
    }

    private fun initData() {
        if (isInternetAvailable(this)){
            viewModel!!.getDataByApi()
        }else{
            viewModel!!.getDataFromDatabase()
        }
    }

    private fun initVariable() {
        apiService = RetrofitHelper.getRetrofitInstance().create(ApiService::class.java)
        database = AppDatabase(this)
        repository = PostsRepository(apiService!!,database!!)
        viewModel = ViewModelProvider(this, PostsViewModelFactory(repository!!))[PostsViewModel::class.java]
    }

    private fun initObserver() {
        showProgress()
        viewModel!!.postData.observe(this) {
            if (it != null){
                mAdapter = PostsAdapter()
                mAdapter!!.setPostsList(it)
                binding!!.rvDemo1.layoutManager = LinearLayoutManager(this)
                binding!!.rvDemo1.adapter = mAdapter
            }
        }
    }

    private fun showProgress() {
        repository!!.progress.observe(this) {
            if (it == true) {
                binding!!.progressDemo1.visibility = View.VISIBLE
            } else {
                binding!!.progressDemo1.visibility = View.GONE
            }
        }
    }
}