package com.example.cat.components

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cat.navigation.BottomNavItem


@Composable
fun BottomNav(navController: NavController){

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Breed
    )
    
    BottomNavigation(backgroundColor = Color.DarkGray, contentColor = Color.White) {

        val navBackEntry by navController.currentBackStackEntryAsState()
        val current = navBackEntry?.destination?.route

        items.forEach{item->
            BottomNavigationItem(
                selected = current == item.screenRoute,
                icon = { Icon(painterResource(id = item.bottomIcon), contentDescription = "Home")},
                label = { Text(text = item.title)},
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.3f),
                alwaysShowLabel = true,
                onClick = {
                    Log.d("BOTTOM", "BottomNav: ${item.screenRoute}")
                    navController.navigate("${item.screenRoute}")
                })
        }

    }
}
//
//@Composable
//fun Items(shape:Shape,icon:ImageVector = Icons.Default.Home){
//    Surface(modifier = Modifier
//        .padding(2.dp)
//        .wrapContentSize()) {
//        Box(modifier = Modifier
//            .size(40.dp)
//            .clip(shape)
//            .background(Color.DarkGray),){
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Icon(imageVector = icon, contentDescription = "Home", tint = Color.White)
//            }
//        }
//    }
//}