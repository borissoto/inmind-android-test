package com.borissoto.postsapp.di

import com.borissoto.postsapp.common.Constants
import com.borissoto.postsapp.data.remote.PostApi
import com.borissoto.postsapp.data.repository.PostRepositoryImpl
import com.borissoto.postsapp.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePostApi(): PostApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(api: PostApi): PostRepository{
        return PostRepositoryImpl(api)
    }
}