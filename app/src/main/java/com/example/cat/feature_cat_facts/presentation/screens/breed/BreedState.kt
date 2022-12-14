package com.example.cat.feature_cat_facts.presentation.screens.breed

import com.example.cat.feature_cat_facts.domain.model.CatBreedResponse

data class BreedState(
    val loading:Boolean? = false,
    val breed: CatBreedResponse? = null,
    val error:String? = null
)
