package com.example.finaldemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finaldemo.repository.ImgTxtRepository

/**
 * Created by Abhin.
 */
class ImgTxtViewModelFactory(private val imgTxtRepository: ImgTxtRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImgTxtViewModel(imgTxtRepository) as T
    }
}