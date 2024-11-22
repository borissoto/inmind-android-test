package com.borissoto.postsapp.presentation.post_list

import com.borissoto.postsapp.domain.model.Post

data class PostListState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String = ""
)