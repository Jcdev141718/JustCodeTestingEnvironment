package com.example.finaldemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.network.ApiService

/**
 * Created by Abhin.
 */
class ImgTxtRepository(var apiService: ApiService) {

    private val imgTxtList = MutableLiveData<ArrayList<ImgTxtResponseItem>>()

    val imgTxt : LiveData<ArrayList<ImgTxtResponseItem>>
        get() = imgTxtList

    suspend fun getImgTxt() {
        val response = apiService.getImgTxtApi()
        if (response.body() != null) {
            imgTxtList.postValue(response.body())
        }
    }

}
