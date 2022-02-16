package com.example.finaldemo.room

import androidx.room.*
import com.example.finaldemo.model.posts.PostsResponseItem

/**
 * Created by Abhin.
 */
@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(postsResponseItem : List<PostsResponseItem>)

    @Update
    suspend fun updatePost(postsResponseItem: PostsResponseItem)

    @Delete
    suspend fun deletePost(postsResponseItem: PostsResponseItem)

    @Query("SELECT * FROM PostsResponseTable")
    suspend fun getAllPost() : List<PostsResponseItem>

}