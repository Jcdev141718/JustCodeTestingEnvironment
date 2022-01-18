package com.example.finaldemo.network

import com.example.finaldemo.model.PostsResponseItem
import com.example.finaldemo.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


/**
 * Created by Abhin.
 */
interface ApiService {

    @GET("posts.json")
    fun getPosts(): Call<List<PostsResponseItem>>

    companion object {
        var apiService: ApiService? = null
        fun getRetrofit(): ApiService {
            if (apiService == null) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
                okHttpClient.readTimeout(120, TimeUnit.SECONDS)
                    .connectTimeout(3, TimeUnit.MINUTES)
                    .writeTimeout(3, TimeUnit.MINUTES)
                okHttpClient.addNetworkInterceptor(logging)
                val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(
                        GsonConverterFactory.create()
                    ).client(okHttpClient.build()).build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}