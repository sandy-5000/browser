package com.example.webbrowser.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.webbrowser.ui.theme.WebBrowserTheme
import com.example.webbrowser.util.BrowserUiState
import com.example.webbrowser.util.DataViewModel

@Composable
fun Login(
    nav: NavController,
    sharedState: BrowserUiState,
    viewModel: DataViewModel,
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
            )
            Text(
                text = "${sharedState.count}",
                modifier = Modifier.padding(5.dp),
            )
            Button(
                onClick = {
                    nav.navigate("home") {
                        viewModel.incrementCount()
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                },
            ) {
                Text(
                    text = "Goto Home",
                )
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun LoginPreview() {
//    WebBrowserTheme {
//        val nav = rememberNavController()
//        Login(nav = nav)
//    }
//}
