package com.hellohasan.mvvmhiltblog.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hellohasan.mvvmhiltblog.blog_list.model.data.BlogEntity

@Database(entities = [BlogEntity::class], version = 1)
abstract class BlogDatabase : RoomDatabase() {
    abstract fun getBlogDao(): BlogDao
}