package com.example.finaldemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finaldemo.model.posts.PostsResponseItem
import com.example.finaldemo.repository.PostsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Abhin.
 */
class PostsViewModel(private val postsRepository: PostsRepository) : ViewModel(){

    val postList = MutableLiveData<List<PostsResponseItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getPosts(){
        val response = postsRepository.getPosts()
        response.enqueue(object : Callback<List<PostsResponseItem>> {
            override fun onResponse(
                call: Call<List<PostsResponseItem>>,
                response: Response<List<PostsResponseItem>>
            ) {
                postList.postValue(response.body()?.take(5))
            }

            override fun onFailure(call: Call<List<PostsResponseItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}