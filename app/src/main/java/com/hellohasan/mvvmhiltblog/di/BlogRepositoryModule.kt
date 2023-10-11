package com.hellohasan.mvvmhiltblog.di

import com.hellohasan.mvvmhiltblog.blog_list.model.local.BlogLocalDataSource
import com.hellohasan.mvvmhiltblog.blog_list.model.local.BlogLocalDataSourceImpl
import com.hellohasan.mvvmhiltblog.blog_list.model.remote.BlogRemoteDataSource
import com.hellohasan.mvvmhiltblog.blog_list.model.remote.BlogRemoteDataSourceImpl
import com.hellohasan.mvvmhiltblog.blog_list.model.repository.BlogRepository
import com.hellohasan.mvvmhiltblog.blog_list.model.repository.BlogRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BlogRepositoryModule {

    @Binds
    fun bindBlogRepository(repository: BlogRepositoryImpl): BlogRepository

    @Binds
    fun bindBlogRemoteDataSource(remoteDataSource: BlogRemoteDataSourceImpl): BlogRemoteDataSource

    @Binds
    fun bindBlogLocalDataSource(localDataSource: BlogLocalDataSourceImpl): BlogLocalDataSource

}