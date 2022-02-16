package com.example.finaldemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finaldemo.repository.GotRepository

/**
 * Created by Abhin.
 */
class GotViewModelFactory (private val gotRepository: GotRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GotViewModel(gotRepository) as T
    }
}