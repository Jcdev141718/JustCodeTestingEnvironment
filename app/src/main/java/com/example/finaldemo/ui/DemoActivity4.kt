package com.example.finaldemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.ImgTxtAdapter4
import com.example.finaldemo.databinding.ActivityDemo4Binding
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.network.RetrofitHelper
import com.example.finaldemo.repository.ImgTxtRepository
import com.example.finaldemo.viewmodel.ImgTxtViewModel
import com.example.finaldemo.viewmodel.ImgTxtViewModelFactory
import java.util.*

class DemoActivity4 : AppCompatActivity() {
    lateinit var mBinding: ActivityDemo4Binding
    lateinit var imgTxtViewModel: ImgTxtViewModel
    lateinit var mAdapter: ImgTxtAdapter4
    var myList = ArrayList<ImgTxtResponseItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDemo4Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val apiService = RetrofitHelper.getRetrofitInstance().create(ApiService::class.java)
        val imgTxtRepository = ImgTxtRepository(apiService)
        imgTxtViewModel = ViewModelProvider(this, ImgTxtViewModelFactory(imgTxtRepository))[ImgTxtViewModel::class.java]

        val myListner = object : ImgTxtAdapter4.ButtonClickInterface{
            override fun clickButton(position: Int, plus: Int?, minus: Int?) {
                if (minus == null && plus != null && plus <= 99) {
                    val plus1 = plus.plus(1)
                    val oldvalue =  myList[position]
                    myList[position] = ImgTxtResponseItem(
                        description = oldvalue.description,
                        id = oldvalue.id,
                        progress = plus1,
                        image = oldvalue.image,
                        text1 = oldvalue.text1,
                        text2 = oldvalue.text2,
                        title = oldvalue.title
                    )
                    mAdapter.updateData(myList)
                }else if(plus == null && minus != null && minus >= 2){
                    val minus1 = minus.minus(1)
                    val oldvalue =  myList[position]
                    myList[position] = ImgTxtResponseItem(
                        description = oldvalue.description,
                        id = oldvalue.id,
                        progress = minus1,
                        image = oldvalue.image,
                        text1 = oldvalue.text1,
                        text2 = oldvalue.text2,
                        title = oldvalue.title
                    )
                    mAdapter.updateData(myList)
                }
            }
        }

        imgTxtViewModel.imgTxt.observe(this, Observer {
            if(it !=null){
                myList.clear()
                myList = it
                mAdapter = ImgTxtAdapter4(it,myListner)
                mBinding.rvDemo4.layoutManager = LinearLayoutManager(this)
                mBinding.rvDemo4.adapter = mAdapter
            }
        })
    }
}