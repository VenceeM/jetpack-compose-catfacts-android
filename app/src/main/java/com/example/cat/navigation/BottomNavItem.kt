package com.example.cat.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cat.R

sealed class BottomNavItem(var title:String, var bottomIcon:Int, var screenRoute:String){

    object Home: BottomNavItem("Home", R.drawable.ic_home_24,"home")
    object Breed: BottomNavItem("Breeds", R.drawable.ic_pets_24,"breed")

}
