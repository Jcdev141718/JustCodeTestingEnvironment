package com.example.finaldemo.ui
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaldemo.adapter.ImgTxtAdapter4
import com.example.finaldemo.databinding.ActivityDemo4Binding
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.network.RetrofitHelper
import com.example.finaldemo.network.isInternetAvailable
import com.example.finaldemo.repository.ImgTxtRepository
import com.example.finaldemo.room.AppDatabase
import com.example.finaldemo.viewmodel.ImgTxtViewModel
import com.example.finaldemo.viewmodel.ImgTxtViewModelFactory

class DemoActivity4 : AppCompatActivity() {
    private var binding: ActivityDemo4Binding? = null
    private var viewModel: ImgTxtViewModel? = null
    private var mAdapter: ImgTxtAdapter4? = null
    private var database: AppDatabase? = null
    private var repository : ImgTxtRepository? = null
    var myList = ArrayList<ImgTxtResponseItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemo4Binding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initVariable()
        val myListner = object : ImgTxtAdapter4.ButtonClickInterface{
            override fun clickButton(position: Int, plus: Int?, minus: Int?) {
                if (minus == null && plus != null && plus <= 99) {
                    val plus1 = plus.plus(1)
                    val oldValue =  myList[position]
                    myList[position] = ImgTxtResponseItem(
                        description = oldValue.description,
                        id = oldValue.id,
                        progress = plus1,
                        image = oldValue.image,
                        text1 = oldValue.text1,
                        text2 = oldValue.text2,
                        title = oldValue.title
                    )
                    mAdapter!!.updateData(myList)
                }else if(plus == null && minus != null && minus >= 1){
                    val minus1 = minus.minus(1)
                    val oldValue =  myList[position]
                    myList[position] = ImgTxtResponseItem(
                        description = oldValue.description,
                        id = oldValue.id,
                        progress = minus1,
                        image = oldValue.image,
                        text1 = oldValue.text1,
                        text2 = oldValue.text2,
                        title = oldValue.title
                    )
                    mAdapter!!.updateData(myList)
                }
            }
        }
        initObserver(myListner)
        initData()
    }

    private fun initVariable() {
        val apiService = RetrofitHelper.getRetrofitInstance().create(ApiService::class.java)
        database = AppDatabase(this)
        repository = ImgTxtRepository(apiService, database!!)
        viewModel = ViewModelProvider(this, ImgTxtViewModelFactory(repository!!))[ImgTxtViewModel::class.java]
    }

    private fun initObserver(myListner: ImgTxtAdapter4.ButtonClickInterface) {
        showProgress()
        viewModel!!.imgTxt.observe(this, Observer {
            if (it != null) {
                myList.clear()
                myList = it
                mAdapter = ImgTxtAdapter4(it, myListner)
                binding!!.rvDemo4.layoutManager = LinearLayoutManager(this)
                binding!!.rvDemo4.adapter = mAdapter
            }
        })
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

    private fun initData() {
        if (isInternetAvailable(this)) {
            viewModel!!.getDataByApiCall()
        } else {
            viewModel!!.getAllDataFromDatabase()
        }
    }
}