package com.example.cat.feature_cat_facts.data.repository

import com.example.cat.feature_cat_facts.data.core.CatFactApi
import com.example.cat.feature_cat_facts.domain.model.CatBreedResponse
import com.example.cat.feature_cat_facts.domain.model.CatFactsResponse
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import javax.inject.Inject

class CatFactRepositoryImpl @Inject constructor(private val api: CatFactApi): CatFactRepository {

    override suspend fun getAllFacts(page:Int): CatFactsResponse {
        return api.getAlLFacts(page)
    }

    override suspend fun getAllBreeds(page:Int): CatBreedResponse {
        return api.getAllBreeds(page)
    }
}