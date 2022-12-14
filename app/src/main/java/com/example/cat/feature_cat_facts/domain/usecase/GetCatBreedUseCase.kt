package com.example.cat.feature_cat_facts.domain.usecase

import com.example.cat.feature_cat_facts.domain.model.CatBreedResponse
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import com.example.cat.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCatBreedUseCase @Inject constructor(private val catFactRepository: CatFactRepository) {

    operator fun invoke(page:Int):Flow<Resource<CatBreedResponse>> = flow {

        try{
            emit(Resource.Loading())
            val result = catFactRepository.getAllBreeds(page)
            emit(Resource.Success(result))

        }catch (e:Exception){
            emit(Resource.Error(null,e.localizedMessage))
        }

    }

}