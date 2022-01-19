package com.example.finaldemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finaldemo.repository.GotRepository

/**
 * Created by Abhin.
 */
class GotViewModelFactory constructor(private val gotRepository: GotRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(GotViewModel::class.java)) {
            GotViewModel(this.gotRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}