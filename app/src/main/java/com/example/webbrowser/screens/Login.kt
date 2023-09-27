package com.example.webbrowser.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.webbrowser.R
import com.example.webbrowser.ui.theme.WebBrowserTheme
import com.example.webbrowser.util.BrowserUiState
import com.example.webbrowser.util.DataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    nav: NavController,
    viewModel: DataViewModel,
    modifier: Modifier = Modifier.fillMaxSize(),
) {

    val uiState by remember { mutableStateOf(viewModel.uiState.value) }

    val name = uiState?.name
    val count = uiState?.count
    var email = uiState?.email!! + ""

    val isError = true

    Column(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_top_right),
                contentDescription = "",
                modifier = Modifier.width(150.dp),
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .padding(bottom = 10.dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    fontSize = 40.sp,
                    fontFamily = FontFamily.SansSerif,
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
            ) {
                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    singleLine = true,
                    label = { Text(if (isError) "Username*" else "Username") },
                    supportingText = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Limit: ${email.length}",
                            textAlign = TextAlign.End,
                        )
                    },
                    isError = false,
                    keyboardActions = KeyboardActions {
                        email
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = "Count: $count",
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
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    WebBrowserTheme {
        val nav = rememberNavController()
        val viewModel: DataViewModel = viewModel()
        Login(nav = nav, viewModel = viewModel)
    }
}
