package com.example.cat.feature_cat_facts.domain.model


import com.google.gson.annotations.SerializedName

data class LinkX(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("label")
    val label: String,
    @SerializedName("url")
    val url: String
)