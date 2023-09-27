package com.example.webbrowser.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.webbrowser.ui.theme.WebBrowserTheme
import com.example.webbrowser.util.BrowserUiState
import com.example.webbrowser.util.DataViewModel

@Composable()
fun Home(
    nav: NavController,
    viewModel: DataViewModel,
    modifier: Modifier = Modifier.fillMaxSize(),
) {

    val uiState by remember { mutableStateOf(viewModel.uiState.value) }

    val name = uiState?.name
    val count = uiState?.count
    val email = uiState?.email

    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Home",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
            )
            Text(
                text = "Count: $count",
                modifier = Modifier.padding(5.dp),
            )
            Button(
                onClick = {
                    nav.navigate("auth") {
                        viewModel.incrementCount()
                        popUpTo("home")
                    }
                },
            ) {
                Text(
                    text = "Goto Login",
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    WebBrowserTheme {
        val nav = rememberNavController()
        val viewModel: DataViewModel = viewModel()
        Home(nav = nav, viewModel = viewModel)
    }
}