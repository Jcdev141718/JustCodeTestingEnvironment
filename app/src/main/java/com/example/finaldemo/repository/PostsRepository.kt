package com.example.finaldemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.finaldemo.model.posts.PostsResponseItem
import com.example.finaldemo.network.ApiService
import com.example.finaldemo.room.AppDatabase
import com.example.finaldemo.room.PostDao

/**
 * Created by Abhin.
 */

class PostsRepository(private val apiService: ApiService, private val database: AppDatabase) {
    private var postDao: PostDao = database.getPostDao()
    var progress = MutableLiveData<Boolean>()


    suspend fun getPost(): List<PostsResponseItem> {
        progress.postValue(true)
        val response = apiService.getPosts()
        if (response.isSuccessful) {
            progress.postValue(false)
            database.getPostDao().insertPost(response.body()!!)
        }
        return response.body()!!.take(5)
    }

    suspend fun getAllPost(): List<PostsResponseItem> {
        return postDao.getAllPost().take(5)
    }

    suspend fun insert(postsResponseItem: List<PostsResponseItem>) {
        return postDao.insertPost(postsResponseItem)
    }

    suspend fun delete(postsResponseItem: PostsResponseItem) {
        return postDao.deletePost(postsResponseItem)
    }

    suspend fun update(postsResponseItem: PostsResponseItem) {
        return postDao.updatePost(postsResponseItem)
    }
}