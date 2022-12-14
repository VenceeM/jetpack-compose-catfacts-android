package com.example.cat.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cat.feature_cat_facts.presentation.screens.BreedScreen
import com.example.cat.feature_cat_facts.presentation.screens.breed.BreedScreenViewModel
import com.example.cat.feature_cat_facts.presentation.screens.home.HomeScreen
import com.example.cat.feature_cat_facts.presentation.screens.home.HomeViewModel
import com.example.cat.feature_cat_facts.presentation.screens.home.detail.HomeDetailScreen

@Composable
fun CatFactNavigationHost(
    modifier: Modifier =Modifier,
    homeViewModel: HomeViewModel,
    breedViewModel:BreedScreenViewModel,
    navController: NavHostController
){
    NavHost(navController = navController, modifier = modifier, startDestination = BottomNavItem.Home.screenRoute){

        composable(BottomNavItem.Home.screenRoute){
            HomeScreen(viewModel = homeViewModel,navController)
        }

        composable(BottomNavItem.Breed.screenRoute){
            BreedScreen(viewModel = breedViewModel, navController = navController)
        }

        composable(ScreenItems.Details.screenName + "?title={title}", arguments = listOf(navArgument("title"){
            defaultValue = ""
        })){
            HomeDetailScreen(it.arguments?.getString("title"), navController = navController)
        }
    }


}