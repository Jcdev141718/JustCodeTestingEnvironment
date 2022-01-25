package com.example.finaldemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.repository.ImgTxtRepository
import kotlinx.coroutines.launch

/**
 * Created by Abhin.
 */
class ImgTxtViewModel(var imgTxtRepository: ImgTxtRepository) : ViewModel() {
    private var imgTxtList = MutableLiveData<ArrayList<ImgTxtResponseItem>>()
    private var count = 0

    val imgTxt: LiveData<ArrayList<ImgTxtResponseItem>>
        get() = imgTxtRepository.imgTxt

    init {
        viewModelScope.launch {
            imgTxtRepository.getImgTxt()
        }
    }

}