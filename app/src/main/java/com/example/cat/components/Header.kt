package com.example.cat.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Header(modifier: Modifier = Modifier,text:String = "Home", showBack:Boolean = true, onBackClick:() -> Unit = {}){
    val back = remember {
        showBack
    }


    Surface(modifier = modifier
        .fillMaxWidth()
        .height(50.dp), color = Color(75, 43, 94)) {
        Row(modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically) {
            if(back){
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                    modifier = Modifier.clickable { onBackClick.invoke() }, tint = Color.White)
            }
        }
        Row(modifier = Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = text, style = MaterialTheme.typography.h6
                , color = Color.White)
        }
    }
}