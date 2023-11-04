package com.hellohasan.mvvmhiltblog.di

import com.hellohasan.mvvmhiltblog.feature.blog_list.model.BlogModel
import com.hellohasan.mvvmhiltblog.feature.blog_list.model.BlogModelImpl
import com.hellohasan.mvvmhiltblog.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return RetrofitClient.client
    }

    @Provides
    fun provideBlogModel(retrofit: Retrofit): BlogModel {
        return BlogModelImpl(retrofit)
    }

}