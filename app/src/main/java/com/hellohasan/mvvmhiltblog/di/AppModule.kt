package com.hellohasan.mvvmhiltblog.di

import com.hellohasan.mvvmhiltblog.blog_list.model.BlogListModel
import com.hellohasan.mvvmhiltblog.blog_list.model.BlogListModelImpl
import com.hellohasan.mvvmhiltblog.network.RetrofitClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    companion object {
        @Provides
        fun provideRetrofitClient(): Retrofit {
            return RetrofitClient.client
        }
    }

    @Binds
    fun bindBlogModel(model: BlogListModelImpl): BlogListModel
}