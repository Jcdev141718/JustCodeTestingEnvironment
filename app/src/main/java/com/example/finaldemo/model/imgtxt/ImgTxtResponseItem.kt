package com.example.finaldemo.model.imgtxt

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abhin.
 */
@Entity(tableName = "ImgTxtResponseItem")
data class ImgTxtResponseItem(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var description: String? = null,
    var progress: Int? = null,
    var image: String? = null,
    var text1: String? = null,
    var text2: String? = null,
    var title: String? = null,
)