package com.example.finaldemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.ImgTxtAdapter
import com.example.finaldemo.databinding.ActivityDemo3Binding
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.network.RetrofitHelper
import com.example.finaldemo.network.isInternetAvailable
import com.example.finaldemo.repository.ImgTxtRepository
import com.example.finaldemo.room.AppDatabase
import com.example.finaldemo.viewmodel.ImgTxtViewModel
import com.example.finaldemo.viewmodel.ImgTxtViewModelFactory

class DemoActivity3 : AppCompatActivity() {
    private var binding: ActivityDemo3Binding? = null
    private var viewModel: ImgTxtViewModel? = null
    private var mAdapter: ImgTxtAdapter? = null
    private var database: AppDatabase? = null
    private var repository: ImgTxtRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemo3Binding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initVariables()
        initObserver()
        initData()
    }

    private fun initData() {
        if (isInternetAvailable(this)) {
            viewModel?.getDataByApiCall()
        } else {
            viewModel?.getAllDataFromDatabase()
        }
    }

    private fun initVariables() {
        val apiService = RetrofitHelper.getRetrofitInstance().create(ApiService::class.java)
        database = AppDatabase(this)
        repository = ImgTxtRepository(apiService, database!!)
        viewModel = ViewModelProvider(this, ImgTxtViewModelFactory(repository!!))[ImgTxtViewModel::class.java]
    }

    private fun initObserver() {
        showProgress()
        viewModel!!.imgTxt.observe(this) {
            if (it != null) {
                mAdapter = ImgTxtAdapter(it)
                binding!!.rvDemo3.layoutManager = LinearLayoutManager(this)
                binding!!.rvDemo3.adapter = mAdapter
            }
        }
    }

    private fun showProgress() {
        repository!!.progress.observe(this) {
            if (it == true) {
                binding!!.progressDemo3.visibility = View.VISIBLE
            } else {
                binding!!.progressDemo3.visibility = View.GONE
            }
        }
    }
}