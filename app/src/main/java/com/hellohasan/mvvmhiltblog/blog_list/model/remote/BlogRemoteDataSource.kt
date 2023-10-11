package com.hellohasan.mvvmhiltblog.blog_list.model.remote

import com.hellohasan.mvvmhiltblog.blog_list.model.ModelCallback

interface BlogRemoteDataSource {
    fun getBlogList(callback: ModelCallback)
}