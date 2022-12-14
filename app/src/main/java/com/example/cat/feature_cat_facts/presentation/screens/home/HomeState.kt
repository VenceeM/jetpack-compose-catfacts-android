package com.example.cat.feature_cat_facts.presentation.screens.home

import com.example.cat.feature_cat_facts.domain.model.CatFactsResponse

data class HomeState(
    val loading:Boolean? = false,
    val catFacts:CatFactsResponse? = null,
    val error:String? = null
)