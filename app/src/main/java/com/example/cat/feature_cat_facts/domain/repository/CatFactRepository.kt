package com.example.cat.feature_cat_facts.domain.repository

import com.example.cat.feature_cat_facts.domain.model.CatBreedResponse
import com.example.cat.feature_cat_facts.domain.model.CatFactsResponse


interface CatFactRepository {

    suspend fun getAllFacts(page:Int):CatFactsResponse
    suspend fun getAllBreeds(page:Int):CatBreedResponse

}