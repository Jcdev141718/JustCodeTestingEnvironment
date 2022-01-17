package com.example.finaldemo.network

import com.example.finaldemo.model.PostsResponseItem
import com.example.finaldemo.util.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Abhin.
 */
interface ApiService {

    @GET("posts.json")
    fun getPosts() : Call<List<PostsResponseItem>>

    companion object{
        var apiService : ApiService? = null
        fun getRetrofit() : ApiService{
            if (apiService == null){
                val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
                    GsonConverterFactory.create()).build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}