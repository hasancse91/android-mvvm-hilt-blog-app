package com.hellohasan.mvvmhiltblog.di

import com.hellohasan.mvvmhiltblog.blog_list.model.BlogListModel
import com.hellohasan.mvvmhiltblog.blog_list.model.BlogListModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BlogModule {

    @Binds
    fun bindBlogModel(model: BlogListModelImpl): BlogListModel
}