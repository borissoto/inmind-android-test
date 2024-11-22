package com.borissoto.postsapp.data.remote

import com.borissoto.postsapp.domain.model.Post
import retrofit2.http.GET

interface PostApi {

    @GET("/posts/")
    suspend fun getPosts(): List<Post>
}