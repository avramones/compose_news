package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeproject.ui.compose.Conversation
import com.example.composeproject.ui.compose.Details
import com.example.composeproject.ui.vm.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartApp(viewModel = viewModel)
        }
    }

    @Composable
    fun StartApp(viewModel: MainViewModel) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "list") {
            composable("list") { Conversation(viewModel, navController) }
            composable("details") { Details(viewModel, navController) }
        }
    }
}
