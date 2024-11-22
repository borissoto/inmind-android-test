package com.borissoto.postsapp.data.remote.dto

import com.borissoto.postsapp.domain.model.Post

data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostDto.toPost(): Post {
    return Post(
        body = body,
        id = id,
        title = title,
        userId = userId
    )
}