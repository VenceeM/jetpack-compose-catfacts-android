package com.example.cat.feature_cat_facts.domain.usecase

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cat.feature_cat_facts.domain.model.CatFactsResponse
import com.example.cat.feature_cat_facts.domain.model.Data
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import com.example.cat.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCatFactUseCase @Inject constructor(private val repository: CatFactRepository){

    operator fun invoke(page:Int): Flow<Resource<CatFactsResponse>> = flow {
        try{
            emit(Resource.Loading<CatFactsResponse>())
            val result = repository.getAllFacts(page)
            emit(Resource.Success<CatFactsResponse>(result))

        }catch (e:Exception){
            emit(Resource.Error<CatFactsResponse>(null,e.localizedMessage))
            Log.d("ERROR", "invoke: ${e.localizedMessage}")
        }
    }


}