package com.example.finaldemo.network

import com.example.finaldemo.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Abhin.
 */
object RetrofitHelper {
    fun getRetrofitInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClient.readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
        okHttpClient.addNetworkInterceptor(logging)
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).client(okHttpClient.build()).build()
    }
}