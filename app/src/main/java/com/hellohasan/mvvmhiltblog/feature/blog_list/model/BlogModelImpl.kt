package com.hellohasan.mvvmhiltblog.feature.blog_list.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class BlogModelImpl @Inject constructor(private val retrofit: Retrofit) : BlogModel {

    override fun fetchBlogList(callback: ModelCallback) {
        val blogApiInterface = retrofit.create<BlogApiInterface>()
        val apiCall = blogApiInterface.getBlogList()

        apiCall.enqueue(object : Callback<List<BlogResponse>> {
            override fun onResponse(
                call: Call<List<BlogResponse>>,
                response: Response<List<BlogResponse>>
            ) {
                val blogList = response.body()

                if (blogList?.isEmpty() == true) {
                    callback.onError("Content not found")
                } else {
                    callback.onSuccess(blogList!!)
                }
            }

            override fun onFailure(call: Call<List<BlogResponse>>, t: Throwable) {
                callback.onError(t.message ?: "Something went wrong")
            }
        })
    }
}