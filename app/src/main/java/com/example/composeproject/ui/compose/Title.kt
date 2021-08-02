package com.example.composeproject.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(text : String) {
    Text(
        text = text,
        fontSize = 24.sp,
        modifier = Modifier.padding(12.dp),
        style = MaterialTheme.typography.body2
    )
}