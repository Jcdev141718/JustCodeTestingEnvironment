package com.example.finaldemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.finaldemo.model.got.GotResponseItem
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.room.AppDatabase
import com.example.finaldemo.room.GotDao

/**
 * Created by Abhin.
 */
class GotRepository(private val apiService: ApiService, private var database: AppDatabase) {
    private val gotDao : GotDao = database.getGotDao()
    var progress = MutableLiveData<Boolean>()

    suspend fun getGot() : List<GotResponseItem>{
        progress.postValue(true)
        val response = apiService.getGotApi()
        if (response.isSuccessful){
            progress.postValue(false)
            database.getGotDao().insertGot(response.body()!!)
        }
        return response.body()!!
    }

    suspend fun insert(gotResponseItem: List<GotResponseItem>) = gotDao.insertGot(gotResponseItem)
    suspend fun update(gotResponseItem: GotResponseItem) = gotDao.updateGot(gotResponseItem)
    suspend fun delete(gotResponseItem: GotResponseItem) = gotDao.deleteGot(gotResponseItem)
    suspend fun getAllGot() : List<GotResponseItem> = gotDao.getAllGot()
}

