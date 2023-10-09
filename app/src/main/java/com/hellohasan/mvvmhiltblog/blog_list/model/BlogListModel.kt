package com.hellohasan.mvvmhiltblog.blog_list.model

interface BlogListModel {
    fun getBlogList(callback: ModelCallback)
}