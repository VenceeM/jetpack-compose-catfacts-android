package com.example.cat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cat.components.BottomNav
import com.example.cat.components.Header
import com.example.cat.feature_cat_facts.presentation.screens.home.HomeScreen
import com.example.cat.feature_cat_facts.presentation.screens.home.HomeViewModel
import com.example.cat.navigation.CatFactNavigationHost
import com.example.cat.ui.theme.CatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = { BottomNav(navController = navController)}) {
                    MyApp(navController = navController)
                }

            }
        }
    }
}

@Composable
fun MyApp(navController: NavHostController) {
    CatFactNavigationHost(homeViewModel = viewModel(), breedViewModel = viewModel() ,navController = navController)
}
