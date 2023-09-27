package com.example.webbrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.webbrowser.screens.Home
import com.example.webbrowser.screens.Login
import com.example.webbrowser.ui.theme.WebBrowserTheme
import com.example.webbrowser.util.DataViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebBrowserTheme {
                val nav = rememberNavController()
                NavHost(navController = nav, startDestination = "home") {
                    composable("home") { entry ->
                        val viewModel = entry.sharedViewModel<DataViewModel>(nav = nav)
                        val state by viewModel.uiState.collectAsStateWithLifecycle()
                        Home(nav = nav, sharedState = state, viewModel = viewModel)
                    }
                    navigation(
                        startDestination = "login",
                        route = "auth",
                    ) {
                        composable("login") { entry ->
                            val viewModel = entry.sharedViewModel<DataViewModel>(nav = nav)
                            val state by viewModel.uiState.collectAsStateWithLifecycle()
                            Login(nav = nav, sharedState = state, viewModel = viewModel)
                        }
                        composable("register") {
                            val viewModel = it.sharedViewModel<DataViewModel>(nav = nav)
                        }
                        composable("forgot_passwd") {
                            val viewModel = it.sharedViewModel<DataViewModel>(nav = nav)
                        }
                    }
                    navigation(
                        startDestination = "webpage",
                        route = "browser",
                    ) {
                        composable("webpage") {
                            val viewModel = it.sharedViewModel<DataViewModel>(nav = nav)
                        }
                        composable("tabs") {
                            val viewModel = it.sharedViewModel<DataViewModel>(nav = nav)
                        }
                    }
                }
            }
        }
    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(nav: NavController): T {
    val navGraph = destination.parent?.route ?: return  viewModel()
    val parentEntry = remember(this) {
        nav.getBackStackEntry(navGraph)
    }
    return viewModel(parentEntry)
}
