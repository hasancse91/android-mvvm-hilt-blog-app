package com.hellohasan.mvvmhiltblog.blog_list.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "blog_item")
data class BlogEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("image") val imageUrl: String,
    @ColumnInfo("modified_date") val date: String,
    @ColumnInfo("content") val content: String,
    @ColumnInfo("excerpt") val excerpt: String,
    @ColumnInfo("is_favorite") val isFavorite: Boolean,
    @ColumnInfo("views") val viewCount: Int,
    @ColumnInfo("link") val link: String
) : Serializable
