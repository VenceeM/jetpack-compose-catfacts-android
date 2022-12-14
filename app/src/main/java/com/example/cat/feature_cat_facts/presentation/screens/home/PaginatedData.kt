package com.example.cat.feature_cat_facts.presentation.screens.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cat.feature_cat_facts.domain.model.Data
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import javax.inject.Inject

class PaginatedData @Inject constructor(private val getCatFactRepository: CatFactRepository): PagingSource<Int,Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try{
            val page = params.key ?: 0
            val response = getCatFactRepository.getAllFacts(page = page)
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = if(response.data.isNotEmpty()) response.currentPage + 1 else null
            )

        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }

}