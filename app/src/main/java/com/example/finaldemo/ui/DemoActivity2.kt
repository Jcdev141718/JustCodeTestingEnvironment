package com.example.finaldemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.GotParentAdapter
import com.example.finaldemo.databinding.ActivityDemo2Binding
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.network.RetrofitHelper
import com.example.finaldemo.network.isInternetAvailable
import com.example.finaldemo.repository.GotRepository
import com.example.finaldemo.room.AppDatabase
import com.example.finaldemo.viewmodel.GotViewModel
import com.example.finaldemo.viewmodel.GotViewModelFactory

class DemoActivity2 : AppCompatActivity() {
    private var binding: ActivityDemo2Binding? = null
    private var viewModel: GotViewModel? = null
    private var mAdapter: GotParentAdapter? = null
    private var database : AppDatabase? = null
    private var repository : GotRepository? = null
    private var apiService : ApiService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemo2Binding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initVariable()
        initObserver()
        initData()
    }

    private fun initData() {
        if (isInternetAvailable(this)){
            viewModel!!.getApiCall()
        }else{
            viewModel!!.getLocalData()
        }
    }

    private fun initVariable() {
        apiService = RetrofitHelper.getRetrofitInstance().create(ApiService::class.java)
        database = AppDatabase(this)
        repository = GotRepository(apiService!!, database!!)
        viewModel = ViewModelProvider(this, GotViewModelFactory(repository!!))[GotViewModel::class.java]
    }

    private fun initObserver() {
        showProgress()
        viewModel!!.gotData.observe(this) {
            if (it != null){
                mAdapter = GotParentAdapter(this)
                mAdapter!!.setGotList(it)
                binding!!.rvDemo2.layoutManager = LinearLayoutManager(this)
                binding!!.rvDemo2.adapter = mAdapter
            }
        }
    }

    private fun showProgress() {
        repository!!.progress.observe(this) {
            if (it == true) {
                binding!!.progressDemo2.visibility = View.VISIBLE
            } else {
                binding!!.progressDemo2.visibility = View.GONE
            }
        }
    }
}