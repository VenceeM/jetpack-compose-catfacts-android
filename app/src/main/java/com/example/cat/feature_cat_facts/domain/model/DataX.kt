package com.example.cat.feature_cat_facts.domain.model


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("breed")
    val breed: String,
    @SerializedName("coat")
    val coat: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("pattern")
    val pattern: String
)