package com.example.finaldemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.room.AppDatabase
import com.example.finaldemo.room.ImgTxtDao

/**
 * Created by Abhin.
 */
class ImgTxtRepository(var apiService: ApiService, var database: AppDatabase, ) {
    private val databaseDao: ImgTxtDao = database.getImgTxtDao()
    var progress = MutableLiveData<Boolean>()


    suspend fun getImgTxtApiCall(): List<ImgTxtResponseItem> {
        progress.postValue(true)
        val response = apiService.getImgTxtApi()
        return try {
            if (response.isSuccessful) {
                progress.postValue(false)
                database.getImgTxtDao().insertImgTxt(response.body()!!)
                response.body()!!
            } else {
                arrayListOf()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            arrayListOf()
        }
    }

    suspend fun insert(imgTxtResponseItem: List<ImgTxtResponseItem>) = databaseDao.insertImgTxt(imgTxtResponseItem)

    suspend fun update(imgTxtResponseItem: ImgTxtResponseItem) = databaseDao.updateImgTxt(imgTxtResponseItem)

    suspend fun delete(imgTxtResponseItem: ImgTxtResponseItem) = databaseDao.deleteImgTxt(imgTxtResponseItem)

    suspend fun getAllImgTxt(): ArrayList<ImgTxtResponseItem> = ArrayList(databaseDao.getAllImgTxt())
}
