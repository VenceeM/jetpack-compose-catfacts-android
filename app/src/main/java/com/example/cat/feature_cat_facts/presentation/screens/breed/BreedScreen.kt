package com.example.cat.feature_cat_facts.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.cat.components.Header
import com.example.cat.feature_cat_facts.domain.model.DataX
import com.example.cat.feature_cat_facts.presentation.screens.breed.BreedScreenViewModel



@Composable
fun BreedScreen(viewModel: BreedScreenViewModel, navController: NavController){
    //var facts = viewModel.state.value.catFacts
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth() , color = Color(53, 117, 66)
    ) {

        Column(horizontalAlignment = Alignment.Start) {
            Header(modifier = Modifier,"Details", showBack = false)
            CatFactsList(viewModel, navController)
        }

    }
}


@Composable
fun CatFactsList(viewModel: BreedScreenViewModel, navController: NavController){
    var state = viewModel.state.value
    val data = viewModel.data.collectAsLazyPagingItems()
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        LazyColumn(contentPadding = PaddingValues(bottom = 55.dp)){
            items(data){item->
                if (item != null) {
                    RowCatFactList(catBreeds = item){
                        //navController.navigate(ScreenItems.Details.screenName + "?title=${it.fact}")
                    }
                }else{
                   Text(text = "Something went wrong")
                }
            }
            when(data.loadState.append){
                is LoadState.Loading -> {
                    item { CircularProgressIndicator() }
                }
                is LoadState.Error->{
                    item{ Text(text = "Something went wrong")}
                }
            }

//            state.breed?.let {
//                items(it.data){ item ->

//                }
//            }
        }
    }
}

@Composable
fun RowCatFactList(modifier: Modifier = Modifier, catBreeds: DataX, onClick:(DataX)->Unit = {}){
    Surface(modifier = Modifier
        .padding(5.dp)
        .clip(RoundedCornerShape(topStart = 20.dp, bottomEnd = 50.dp))
        .fillMaxWidth()
        .fillMaxHeight()
        .clickable { onClick.invoke(catBreeds) },
        color = Color(37, 125, 86)
    ) {
        Column(modifier = modifier
            .padding(10.dp)
            .fillMaxHeight()) {
            Text(text = catBreeds.breed, style = TextStyle(fontWeight = FontWeight.Bold,color = Color.White, fontSize = 18.sp), maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Text(text = catBreeds.coat, style = TextStyle(fontWeight = FontWeight.Bold,color = Color.White, fontSize = 18.sp), maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Text(text = catBreeds.country, style = TextStyle(fontWeight = FontWeight.Bold,color = Color.White, fontSize = 18.sp), maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Text(text = catBreeds.origin, style = TextStyle(fontWeight = FontWeight.Bold,color = Color.White, fontSize = 18.sp), maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Text(text = catBreeds.pattern, style = TextStyle(fontWeight = FontWeight.Bold,color = Color.White, fontSize = 18.sp), maxLines = 2,
                overflow = TextOverflow.Ellipsis)
        }
    }
}