package com.hellohasan.mvvmhiltblog.di

import android.content.Context
import androidx.room.Room
import com.hellohasan.mvvmhiltblog.db.BlogDatabase
import com.hellohasan.mvvmhiltblog.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    companion object {
        @Provides
        fun provideRetrofitClient(): Retrofit {
            return RetrofitClient.client
        }

        @Provides
        @Singleton
        fun provideBlogDatabase(@ApplicationContext context: Context): BlogDatabase {

            return Room.databaseBuilder(
                name = "blog.db",
                context = context,
                klass = BlogDatabase::class.java
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}