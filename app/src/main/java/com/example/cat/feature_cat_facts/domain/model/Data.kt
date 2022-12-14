package com.example.cat.feature_cat_facts.domain.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("fact")
    val fact: String,
    @SerializedName("length")
    val length: Int
)