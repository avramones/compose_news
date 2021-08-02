package com.example.composeproject.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.example.composeproject.utils.toCorrectDate

@Composable
fun Details(viewModel: MainViewModel, navController: NavController) {

    val article: Article by viewModel.article.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Image(
            painter = rememberImagePainter(article.urlToImage),
            contentDescription = "Description",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = article.title.toString(),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(0.dp, 20.dp)
        )
        Text(
            text = article.description.toString(),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = article.publishedAt.toString().toCorrectDate(),
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .padding(0.dp, 20.dp)
                .fillMaxWidth()
        )
    }
}