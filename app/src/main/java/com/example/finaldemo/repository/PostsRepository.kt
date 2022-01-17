package com.example.finaldemo.repository

import com.example.finaldemo.network.ApiService

/**
 * Created by Abhin.
 */

class PostsRepository (private val apiService: ApiService){
     fun getPosts() = apiService.getPosts()
}
