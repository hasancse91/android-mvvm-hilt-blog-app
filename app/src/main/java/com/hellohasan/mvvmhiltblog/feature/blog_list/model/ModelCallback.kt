package com.hellohasan.mvvmhiltblog.feature.blog_list.model

interface ModelCallback {
    fun onSuccess(list: List<BlogResponse>)
    fun onError(error: String)
}