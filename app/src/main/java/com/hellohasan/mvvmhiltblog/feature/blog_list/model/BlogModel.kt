package com.hellohasan.mvvmhiltblog.feature.blog_list.model

interface BlogModel {
    fun fetchBlogList(callback: ModelCallback)
}