package com.hellohasan.mvvmhiltblog.blog_list.model.repository

import com.hellohasan.mvvmhiltblog.blog_list.model.ModelCallback

interface BlogRepository {
    fun getBlogList(callback: ModelCallback)
}