package com.borissoto.postsapp.data.repository

import com.borissoto.postsapp.data.remote.PostApi
import com.borissoto.postsapp.domain.model.Post
import com.borissoto.postsapp.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
): PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts()
    }

}