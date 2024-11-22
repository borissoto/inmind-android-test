package com.borissoto.postsapp.domain.use_case

import com.borissoto.postsapp.common.Resource
import com.borissoto.postsapp.domain.model.Post
import com.borissoto.postsapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(): Flow<Resource<List<Post>>> = flow {
        try {
            emit(Resource.Loading())
            val posts = repository.getPosts()
            emit(Resource.Success(posts))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }catch (e: IOException){
           emit(Resource.Error("Internet connection error"))
        }
    }
}