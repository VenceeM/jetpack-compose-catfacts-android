package com.example.cat.feature_cat_facts.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.cat.components.Header
import com.example.cat.feature_cat_facts.domain.model.CatFactsResponse
import com.example.cat.feature_cat_facts.domain.model.Data
import com.example.cat.navigation.BottomNavItem
import com.example.cat.navigation.ScreenItems
import kotlinx.coroutines.flow.onEach

@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController){
    //var facts = viewModel.state.value.catFacts
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth() , color = Color(53, 117, 66)) {

        Column(horizontalAlignment = Alignment.Start) {
            Header(modifier = Modifier,"Home", showBack = false)
            CatFactsList(viewModel, navController)
        }

    }
}


@Composable
fun CatFactsList(viewModel: HomeViewModel,navController: NavController){
    var state = viewModel.state.value
    var pager = viewModel.pager.collectAsLazyPagingItems()

    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        LazyColumn(contentPadding = PaddingValues(bottom = 55.dp)){
            items(pager){item->
                if (item != null) {
                    RowCatFactList(catFacts = item){
                        navController.navigate(ScreenItems.Details.screenName + "?title=${it.fact}")
                    }
                }
            }
            when(pager.loadState.append){
                is LoadState.Loading->{
                    item { CircularProgressIndicator() }
                }
                is LoadState.Error->{
                    item{ Text(text = "Something went wrong")}
                }
            }
        }
    }
}

@Composable
fun RowCatFactList(modifier:Modifier = Modifier,catFacts:Data, onClick:(Data)->Unit = {}){
    Surface(modifier = Modifier
        .padding(5.dp)
        .clip(RoundedCornerShape(topStart = 20.dp, bottomEnd = 50.dp))
        .fillMaxWidth()
        .fillMaxHeight()
        .clickable { onClick.invoke(catFacts) },
    color = Color(37, 125, 86)) {
        Column(modifier = modifier
            .padding(10.dp)
            .height(50.dp)) {
            Text(text = catFacts.fact, style = TextStyle(fontWeight = FontWeight.Bold,color = Color.White, fontSize = 18.sp), maxLines = 2,
            overflow = TextOverflow.Ellipsis)
        }
    }
}