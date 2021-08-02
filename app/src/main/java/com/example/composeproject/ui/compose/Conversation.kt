package com.example.composeproject.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeproject.R
import com.example.composeproject.model.Article
import com.example.composeproject.model.History
import com.example.composeproject.ui.vm.MainViewModel

@Composable
fun Conversation(viewModel: MainViewModel, navController: NavController) {

    val articles: List<Article> by viewModel.articles.collectAsState(listOf())
    val histories: List<History> by viewModel.histories.collectAsState(listOf())
    val scrollState = rememberLazyListState()

    Box {
        Image(
            painter = painterResource(
                id = R.drawable.background
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        LazyColumn(
            state = scrollState
        )
        {

            item {
                Title(text = "Истории")
            }

            item {
                LazyRow {
                    items(histories) {
                        HistoryBlock(history = it)
                    }
                }
            }

            item {
                Title(text = "Новости")
            }

            items(articles) {
                SingleNews(viewModel, article = it, navController)
            }
        }
    }


}
