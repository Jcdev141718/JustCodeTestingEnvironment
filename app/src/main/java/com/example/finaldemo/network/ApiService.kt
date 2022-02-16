package com.example.finaldemo.network

import com.example.finaldemo.model.got.GotResponseItem
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.model.posts.PostsResponseItem
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Abhin.
 */
interface ApiService {

    @GET("posts.json")
    suspend fun getPosts(): Response<List<PostsResponseItem>>

    @GET("got.json")
    suspend fun getGotApi(): Response<List<GotResponseItem>>

    @GET("myimgtext.json")
    suspend fun getImgTxtApi(): Response<ArrayList<ImgTxtResponseItem>>

}