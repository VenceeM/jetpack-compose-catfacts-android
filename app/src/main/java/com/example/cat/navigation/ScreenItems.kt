package com.example.cat.navigation

sealed class ScreenItems(var screenName:String) {
    object Details: ScreenItems("details")
}