package com.example.cat.feature_cat_facts.presentation.screens.home.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cat.components.Header

@Preview
@Composable
fun HomeDetailScreen(title:String? = "Title", navController:NavController = rememberNavController()){
    
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
            Header(modifier = Modifier,"Details", showBack = true){
                navController.popBackStack()
            }
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(10.dp),
                verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = title!!, style = MaterialTheme.typography.h6)
            }

            
        }
        
    }
    
}