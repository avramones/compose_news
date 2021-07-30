package com.example.composeproject.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.composeproject.model.Article
import com.example.composeproject.ui.vm.MainViewModel

@Composable
fun MainEvent(viewModel: MainViewModel, article: Article, navController: NavController) {

    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 5.dp
    ) {

        var isExpanded by remember { mutableStateOf(false) }

        Row(modifier = Modifier
            .padding(all = 8.dp)
            .clickable {
           //     isExpanded = !isExpanded
                navController.navigate("details")
                viewModel.setArticle(article = article)

            }) {
            Image(
                painter = rememberImagePainter(article.urlToImage),
                contentDescription = "Description",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(18.dp))
            Column  {
                Text(
                    text = article.title.toString(),
                    color = Color.Blue,
                    fontSize = 18.sp,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = article.description.toString(),
                    maxLines = if (isExpanded) 10 else 3
                )
            }
        }
    }
}