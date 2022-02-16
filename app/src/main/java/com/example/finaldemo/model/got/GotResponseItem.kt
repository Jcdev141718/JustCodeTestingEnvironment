package com.example.finaldemo.model.got

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GotResponseTable")
data class GotResponseItem(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var members: List<Member>,
    var name: String? = null,
    var slug: String? = null,
)