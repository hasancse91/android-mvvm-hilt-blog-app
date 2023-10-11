package com.hellohasan.mvvmhiltblog.blog_list.model.repository

import com.hellohasan.mvvmhiltblog.blog_list.model.ModelCallback
import com.hellohasan.mvvmhiltblog.blog_list.model.data.BlogResponse
import com.hellohasan.mvvmhiltblog.blog_list.model.local.BlogLocalDataSource
import com.hellohasan.mvvmhiltblog.blog_list.model.remote.BlogRemoteDataSource
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(
    private val remoteDataSource: BlogRemoteDataSource,
    private val localDataSource: BlogLocalDataSource
) : BlogRepository {

    override fun getBlogList(callback: ModelCallback) {

        // TODO data from db

        remoteDataSource.getBlogList(object : ModelCallback {
            override fun onSuccess(blogResponseList: List<BlogResponse>) {
                // TODO: save data on db
                callback.onSuccess(blogResponseList)
            }

            override fun onError(error: String) {
                callback.onError(error)
            }

        })
    }
}