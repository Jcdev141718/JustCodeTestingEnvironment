package com.example.finaldemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finaldemo.model.posts.PostsResponseItem
import com.example.finaldemo.repository.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Abhin.
 */
class PostsViewModel(private val postsRepository: PostsRepository) : ViewModel() {

    private val postList = MutableLiveData<List<PostsResponseItem>>()
    val postData: LiveData<List<PostsResponseItem>> = postList

    fun getDataByApi() {
        viewModelScope.launch(Dispatchers.IO) {
            postList.postValue(postsRepository.getPost())
        }
    }

    fun getDataFromDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            postList.postValue(postsRepository.getAllPost())
        }
    }

}