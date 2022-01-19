package com.example.finaldemo.model.posts

data class PostsResponseItem(
    val body: String,
    val id: Int?,
    val title: String?,
    val userId: Int?
)