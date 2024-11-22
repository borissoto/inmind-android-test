package com.borissoto.postsapp.presentation.post_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borissoto.postsapp.common.Resource
import com.borissoto.postsapp.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    val getPostsUseCase: GetPostsUseCase
):ViewModel() {

    private val _state = mutableStateOf(PostListState())
    val state: State<PostListState> = _state

    init {
        getPosts()
    }

    fun getPosts(){
        getPostsUseCase().onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = PostListState(posts = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PostListState(error = it.message ?: "Unexpected Error")
                }
                is Resource.Loading ->{
                    _state.value = PostListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}