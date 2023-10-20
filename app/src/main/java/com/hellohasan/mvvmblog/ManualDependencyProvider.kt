package com.hellohasan.mvvmblog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvmblog.feature.blog_list.model.BlogModel
import com.hellohasan.mvvmblog.feature.blog_list.model.BlogModelImpl
import com.hellohasan.mvvmblog.feature.blog_list.view_model.BlogViewModel
import com.hellohasan.mvvmblog.network.RetrofitClient
import retrofit2.Retrofit

object ManualDependencyProvider {

    fun getBlogViewModelFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {

                val blogModel: BlogModel = getBlogModel()

                return BlogViewModel(blogModel) as T
            }
        }
    }

    fun getBlogModel(): BlogModel {
        return BlogModelImpl(getRetrofit())
    }

    fun getRetrofit(): Retrofit {
        return RetrofitClient.client
    }

}

