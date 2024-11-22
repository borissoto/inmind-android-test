package com.borissoto.postsapp.presentation.post_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.borissoto.postsapp.domain.model.Post

@Composable
fun PostListItem(
    post: Post
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),

        ) {
        Text(text = "ID: ${post.id}", color = Color.Red)
        Text(text = "TITLE: ${post.title} ${post.id}", color = Color.Blue)
        Text(text = "BODY: ${post.body}", color = Color.Gray)
        Text(
            text = "USER ID: ${post.userId}",
            color = Color.LightGray
        )
    }
}