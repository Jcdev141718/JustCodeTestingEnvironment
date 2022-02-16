package com.example.finaldemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finaldemo.model.got.GotResponseItem
import com.example.finaldemo.repository.GotRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Abhin.
 */
class GotViewModel(private val gotRepository: GotRepository) : ViewModel() {

    private val gotList = MutableLiveData<List<GotResponseItem>>()
    val gotData : LiveData<List<GotResponseItem>> = gotList

    fun getApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            gotList.postValue(gotRepository.getGot())
        }
    }

    fun getLocalData(){
        viewModelScope.launch(Dispatchers.IO) {
            gotList.postValue(gotRepository.getAllGot())
        }
    }
}