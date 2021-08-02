package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeproject.ui.compose.Conversation
import com.example.composeproject.ui.compose.Details
import com.example.composeproject.ui.vm.MainViewModel
import com.example.composeproject.utils.Destination

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
        var showMenu by remember { mutableStateOf(false) }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "COMPOSE NEWS"
                        )
                    },
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                    actions = {
                        IconButton(onClick = {
                            showMenu = !showMenu
                        }) {
                            Icon(Icons.Filled.Menu, "")
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = {
                                showMenu = false
                            }
                        )
                        {
                            DropdownMenuItem(onClick = { /*TODO*/ }) {
                                Text("Настройки")
                            }
                            DropdownMenuItem(onClick = { /*TODO*/ }) {
                                Text("Выход")
                            }
                        }
                    }
                )
            },
            content = {
                NavHost(navController = navController, startDestination = Destination.MAIN) {
                    composable(Destination.MAIN) {
                        Conversation(viewModel, navController)
                    }
                    composable(Destination.DETAIL) {
                        Details(viewModel, navController) }
                }
            })
    }
}
