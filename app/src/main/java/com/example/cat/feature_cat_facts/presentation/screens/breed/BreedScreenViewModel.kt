package com.example.cat.feature_cat_facts.presentation.screens.breed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import com.example.cat.feature_cat_facts.domain.usecase.GetCatBreedUseCase
import com.example.cat.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BreedScreenViewModel @Inject constructor(private val getCatBreedUseCase: GetCatBreedUseCase,private val repository: CatFactRepository):ViewModel() {

    private val _state = mutableStateOf(BreedState())
    val state: State<BreedState> = _state

    val data = Pager(PagingConfig(pageSize = 10)){
        PaginatedData(repository)
    }.flow.cachedIn(viewModelScope)

    init {
        getAllBreeds(page = 1)

    }

    fun getAllBreeds(page:Int){
        getCatBreedUseCase(page).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = BreedState(breed = result.data)
                }
                is Resource.Error -> {
                    _state.value = BreedState(error = result.message)
                }
                is Resource.Loading -> {
                    _state.value = BreedState(loading = true)
                }
            }

        }.launchIn(viewModelScope)
    }

}