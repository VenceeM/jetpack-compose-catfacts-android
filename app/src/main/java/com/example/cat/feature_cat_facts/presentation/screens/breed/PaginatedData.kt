package com.example.cat.feature_cat_facts.presentation.screens.breed

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cat.feature_cat_facts.domain.model.DataX
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import javax.inject.Inject

class PaginatedData @Inject constructor(private val repository: CatFactRepository): PagingSource<Int,DataX>() {

    override fun getRefreshKey(state: PagingState<Int, DataX>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataX> {
         return try{

                 // get the current page
                 val page = params.key ?: 0
                //Get the response from the api and passed the page
                 val response = repository.getAllBreeds(page = page)

                // pass the response.data as data
                // nextKey check if the response.data is not empty then increment by 1 the
                // currentPage of response
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