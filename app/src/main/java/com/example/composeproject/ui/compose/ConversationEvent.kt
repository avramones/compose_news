package com.example.composeproject.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeproject.model.Article
import com.example.composeproject.model.History
import com.example.composeproject.ui.vm.MainViewModel

@Composable
fun Conversation(viewModel: MainViewModel, navController: NavController) {

    val articles: List<Article> by viewModel.articles.collectAsState(listOf())
    val histories: List<History> by viewModel.histories.collectAsState(listOf())

    Column {
        TopAppBar(
            title = {
                Text(
                    text = "COMPOSE NEWS"
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

        LazyColumn {

            item {
                Text(
                    text = "Истории",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.body2
                )
            }

            item {
                LazyRow {
                    items(histories) {
                        HistoryBlock(history = it)
                    }
                }
            }

            item {
                Text(
                    text = "Новости",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.body2
                )
            }

            items(articles) {
                MainEvent(viewModel, article = it, navController)
            }
        }
    }

}
