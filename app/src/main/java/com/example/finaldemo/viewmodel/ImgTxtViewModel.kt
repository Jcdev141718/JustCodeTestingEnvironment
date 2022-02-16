package com.example.finaldemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.repository.ImgTxtRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Abhin.
 */
class ImgTxtViewModel(var repository: ImgTxtRepository) : ViewModel() {

    private val imgTxtList = MutableLiveData<ArrayList<ImgTxtResponseItem>>()
    val imgTxt: LiveData<ArrayList<ImgTxtResponseItem>> = imgTxtList

    fun getDataByApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            imgTxtList.postValue(ArrayList(repository.getImgTxtApiCall()))
        }
    }

    suspend fun updateData(imgTxtResponseItem: ImgTxtResponseItem) = repository.update(imgTxtResponseItem)

    suspend fun deleteData(imgTxtResponseItem: ImgTxtResponseItem) = repository.delete(imgTxtResponseItem)

    fun getAllDataFromDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            imgTxtList.postValue(repository.getAllImgTxt())
        }
    }
}