package com.example.finaldemo.repository

import com.example.finaldemo.network.ApiService

/**
 * Created by Abhin.
 */
class GotRepository(private val apiService: ApiService) {
    fun getGot() = apiService.getGotApi()
}