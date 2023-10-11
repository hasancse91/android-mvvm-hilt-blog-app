package com.hellohasan.mvvmhiltblog.blog_list.model.local

import com.hellohasan.mvvmhiltblog.blog_list.model.data.BlogResponse

interface BlogLocalDataSource {
    fun getBlogList(): List<BlogResponse>
    fun saveBlogList(list: List<BlogResponse>): Boolean
}