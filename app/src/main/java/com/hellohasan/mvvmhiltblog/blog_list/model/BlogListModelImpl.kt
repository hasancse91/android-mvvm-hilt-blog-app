package com.hellohasan.mvvmhiltblog.blog_list.model

import com.hellohasan.mvvmhiltblog.blog_list.model.data.BlogResponse
import com.hellohasan.mvvmhiltblog.blog_list.model.remote.BlogApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class BlogListModelImpl @Inject constructor(private val retrofit: Retrofit) : BlogListModel {

    override fun getBlogList(callback: ModelCallback) {
        val blogApiInterface = retrofit.create<BlogApiInterface>()
        val apiCall = blogApiInterface.getBlogList()

        apiCall.enqueue(object : Callback<List<BlogResponse>> {

            override fun onResponse(
                call: Call<List<BlogResponse>>,
                response: Response<List<BlogResponse>>
            ) {
                if (response.isSuccessful && response.code() == 200) {
                    val blogList: List<BlogResponse>? = response.body()

                    if (blogList.isNullOrEmpty()) {
                        callback.onError("Content not found")
                    } else {
                        callback.onSuccess(blogList)
                    }
                } else {
                    callback.onError("Error code: ${response.code()}. ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<BlogResponse>>, t: Throwable) {
                callback.onError(t.message ?: "Something went wrong!")
            }
        })

    }

}