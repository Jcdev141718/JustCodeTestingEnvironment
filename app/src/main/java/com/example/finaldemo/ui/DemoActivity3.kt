package com.example.finaldemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.ImgTxtAdapter
import com.example.finaldemo.databinding.ActivityDemo3Binding
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.network.RetrofitHelper
import com.example.finaldemo.repository.ImgTxtRepository
import com.example.finaldemo.viewmodel.ImgTxtViewModel
import com.example.finaldemo.viewmodel.ImgTxtViewModelFactory

class DemoActivity3 : AppCompatActivity() {
    lateinit var mBinding: ActivityDemo3Binding
    lateinit var imgTxtViewModel: ImgTxtViewModel
    lateinit var mAdapter: ImgTxtAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDemo3Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val apiService = RetrofitHelper.getRetrofitInstance().create(ApiService::class.java)
        val imgTxtRepository = ImgTxtRepository(apiService)
        imgTxtViewModel = ViewModelProvider(this,ImgTxtViewModelFactory(imgTxtRepository))[ImgTxtViewModel::class.java]

        imgTxtViewModel.imgTxt.observe(this, Observer {
            if(it !=null){
                mAdapter = ImgTxtAdapter(this,it)
                mBinding.rvDemo3.layoutManager = LinearLayoutManager(this)
                mBinding.rvDemo3.adapter = mAdapter
            }
        })
    }

}