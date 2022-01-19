package com.example.finaldemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.GotParentAdapter
import com.example.finaldemo.databinding.ActivityDemo2Binding
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.repository.GotRepository
import com.example.finaldemo.viewmodel.GotViewModel
import com.example.finaldemo.viewmodel.GotViewModelFactory

class DemoActivity2 : AppCompatActivity() {
    lateinit var mBinding: ActivityDemo2Binding
    lateinit var gotViewModel: GotViewModel
    lateinit var gotAdapter: GotParentAdapter
    private var apiService = ApiService.getRetrofit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDemo2Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        gotViewModel = ViewModelProvider(this, GotViewModelFactory(GotRepository(apiService)))[GotViewModel::class.java]
        gotViewModel.getGot()
        gotViewModel.gotList.observe(this,{
            gotAdapter.setGotList(it)
        })
        mBinding.rvDemo2.layoutManager = LinearLayoutManager(this)
        gotAdapter = GotParentAdapter(this)
        mBinding.rvDemo2.adapter = gotAdapter
    }
}