package com.hellohasan.mvvmhiltblog.blog_list.model

import com.hellohasan.mvvmhiltblog.blog_list.model.data.BlogResponse

interface ModelCallback {
    fun onSuccess(blogResponseList: List<BlogResponse>)
    fun onError(error: String)
}