package com.hellohasan.mvvmhiltblog.blog_list.model.local

import com.hellohasan.mvvmhiltblog.blog_list.model.data.BlogResponse
import javax.inject.Inject

class BlogLocalDataSourceImpl @Inject constructor() : BlogLocalDataSource {
    override fun getBlogList(): List<BlogResponse> {
        TODO("Not yet implemented")
    }

    override fun saveBlogList(list: List<BlogResponse>): Boolean {
        TODO("Not yet implemented")
    }

}