package com.example.finaldemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finaldemo.model.got.GotResponseItem
import com.example.finaldemo.repository.GotRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Abhin.
 */
class GotViewModel(private val gotRepository: GotRepository) : ViewModel() {

    val gotList = MutableLiveData<List<GotResponseItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getGot() {
        val response = gotRepository.getGot()
        response.enqueue(object : Callback<List<GotResponseItem>> {
            override fun onResponse(
                call: Call<List<GotResponseItem>>,
                response: Response<List<GotResponseItem>>
            ) {
                gotList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<GotResponseItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}