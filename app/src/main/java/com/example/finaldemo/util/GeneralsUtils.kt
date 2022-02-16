package com.example.finaldemo.util

import androidx.room.TypeConverter
import com.example.finaldemo.model.got.Member
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Abhin.
 */
class MemberConverter {
    @TypeConverter
    fun toMember(json: String): List<Member> {
        val type = object : TypeToken<List<Member>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(member: List<Member>): String {
        val type = object: TypeToken<List<Member>>() {}.type
        return Gson().toJson(member, type)
    }
}