package com.example.webbrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.webbrowser.screens.Home
import com.example.webbrowser.screens.Login
import com.example.webbrowser.screens.Register
import com.example.webbrowser.ui.theme.WebBrowserTheme
import com.example.webbrowser.util.DataViewModel

class MainActivity : ComponentActivity() {
    private val sharedViewModel: DataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebBrowserTheme {
                val nav = rememberNavController()
                NavHost(navController = nav, startDestination = "home") {
                    composable("home") {
                        Home(nav = nav, viewModel = sharedViewModel)
                    }
                    navigation(
                        startDestination = "login",
                        route = "auth",
                    ) {
                        composable("login") {
                            Login(nav = nav, viewModel = sharedViewModel)
                        }
                        composable("register") {
                            Register(nav = nav, viewModel = sharedViewModel)
                        }
                        composable("forgot_passwd") {
                        }
                    }
                    navigation(
                        startDestination = "webpage",
                        route = "browser",
                    ) {
                        composable("webpage") {
                        }
                        composable("tabs") {
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
