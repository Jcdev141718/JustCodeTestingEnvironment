package com.example.finaldemo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.finaldemo.model.got.GotResponseItem
import com.example.finaldemo.model.imgtxt.ImgTxtResponseItem
import com.example.finaldemo.model.posts.PostsResponseItem
import com.example.finaldemo.util.MemberConverter

/**
 * Created by Abhin.
 */
@Database(entities = [ImgTxtResponseItem::class, GotResponseItem::class, PostsResponseItem::class], version = 1)
@TypeConverters(MemberConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getImgTxtDao(): ImgTxtDao
    abstract fun getGotDao() : GotDao
    abstract fun getPostDao() : PostDao

    companion object {
        private const val DB_NAME = "imgTxt_database.db"
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }
}