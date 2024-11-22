package com.borissoto.postsapp.domain.repository

import com.borissoto.postsapp.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}