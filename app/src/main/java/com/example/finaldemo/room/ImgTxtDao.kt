package com.example.finaldemo.room

import androidx.room.*
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem

/**
 * Created by Abhin.
 */
@Dao
interface ImgTxtDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImgTxt(imgTxtResponseItem: List<ImgTxtResponseItem>)

    @Update
    suspend fun updateImgTxt(imgTxtResponseItem: ImgTxtResponseItem)

    @Delete
    suspend fun deleteImgTxt(imgTxtResponseItem: ImgTxtResponseItem)

    @Query("SELECT * FROM ImgTxtResponseItem")
    suspend fun getAllImgTxt(): List<ImgTxtResponseItem>

}