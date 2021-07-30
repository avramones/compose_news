package com.example.composeproject.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.composeproject.model.Article
import com.example.composeproject.ui.vm.MainViewModel

@Composable
fun Details(viewModel: MainViewModel, navController: NavController) {

    val article: Article by viewModel.article.collectAsState()

    Column() {
        TopAppBar(
            title = {
                Text(
                    text = article.title.toString(),
                    maxLines = 1
                )
            },
            backgroundColor = Color.Blue,
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu, "")
                }
            },
            contentColor = Color.White
        )

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = rememberImagePainter(article.urlToImage),
                    contentDescription = "Description",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .padding(30.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
}