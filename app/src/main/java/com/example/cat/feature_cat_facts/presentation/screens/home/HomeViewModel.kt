package com.example.cat.feature_cat_facts.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.cat.feature_cat_facts.data.core.CatFactApi
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import com.example.cat.feature_cat_facts.domain.usecase.GetCatFactUseCase
import com.example.cat.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCatFactUseCase: GetCatFactUseCase, private val api:CatFactApi,private val repository: CatFactRepository):ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state:MutableState<HomeState> = _state

    val pager = Pager(PagingConfig(pageSize = 10)){
        PaginatedData(repository)
    }.flow.cachedIn(viewModelScope)

    init {
        getAlLFacts(page = 1)
    }

    fun getAlLFacts(page:Int){
        getCatFactUseCase(page).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = HomeState(catFacts = result.data)
                }
                is Resource.Error -> {
                    _state.value = HomeState(error = result.message)
                }
                is Resource.Loading -> {
                    _state.value = HomeState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}