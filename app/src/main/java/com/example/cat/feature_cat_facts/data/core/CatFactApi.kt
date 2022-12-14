package com.example.cat.feature_cat_facts.data.core

import com.example.cat.feature_cat_facts.domain.model.CatBreedResponse
import com.example.cat.feature_cat_facts.domain.model.CatFactsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface CatFactApi {

    @GET("facts")
    suspend fun getAlLFacts(@Query("page") page:Int = 1): CatFactsResponse

    @GET("breeds")
    suspend fun getAllBreeds(@Query("page") page:Int = 1): CatBreedResponse

}