package com.example.finaldemo.room

import androidx.room.*
import com.example.finaldemo.model.got.GotResponseItem

/**
 * Created by Abhin.
 */
@Dao
interface GotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGot(gotResponseItem: List<GotResponseItem>)

    @Update
    suspend fun updateGot(gotResponseItem: GotResponseItem)

    @Delete
    suspend fun deleteGot(gotResponseItem: GotResponseItem)

    @Query("SELECT * FROM GotResponseTable")
    suspend fun getAllGot(): List<GotResponseItem>
}