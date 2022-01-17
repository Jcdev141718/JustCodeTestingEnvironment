package com.example.finaldemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finaldemo.repository.PostsRepository

/**
 * Created by Abhin.
 */
class MyViewModelFactory constructor(private val postsRepository: PostsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
            PostsViewModel(this.postsRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}