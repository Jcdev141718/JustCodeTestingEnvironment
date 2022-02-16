package com.example.finaldemo.model.posts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostsResponseTable")
data class PostsResponseItem(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val body: String? = null,
    val title: String? = null,
    val userId: Int? = null,
)