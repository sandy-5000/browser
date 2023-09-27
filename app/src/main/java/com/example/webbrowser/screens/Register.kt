package com.example.webbrowser.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.webbrowser.R
import com.example.webbrowser.ui.theme.WebBrowserTheme
import com.example.webbrowser.util.DataViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(
    nav: NavController,
    viewModel: DataViewModel,
    modifier: Modifier = Modifier,
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val uiState by remember { mutableStateOf(viewModel.uiState.value) }

    var username by remember { mutableStateOf(uiState?.username!! + "") }
    var password by remember { mutableStateOf(uiState?.password!! + "") }

    val defaultPasswd = uiState?.defaultPassword

    val isError = false
    val maxUserNameLength = 30

    fun validateUserName(username: String): Boolean {
        return username.length <= 30
    }

    Column(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            horizontalAlignment = Alignment.End,
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_top_right),
                contentDescription = "",
                modifier = Modifier.width(150.dp),
            )
        }
        Row(
            modifier = Modifier
                .height(screenHeight - 300.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Register",
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray,
                        fontSize = 40.sp,
                        fontFamily = FontFamily.SansSerif,
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 15.dp),
                ) {
                    TextField(
                        value = username,
                        onValueChange = {
                            if (!validateUserName(it)) {
                                return@TextField
                            }
                            username = it
                            uiState?.username = username
                        },
                        singleLine = true,
                        label = { Text(if (isError) "Username*" else "Username") },
                        supportingText = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Limit: ${username.length}/$maxUserNameLength",
                                textAlign = TextAlign.End,
                                color = Color.Gray,
                            )
                        },
                        isError = false,
                        keyboardActions = KeyboardActions { },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFE2E8F0),
                            textColor = Color.DarkGray,
                            unfocusedLabelColor = Color.Gray,
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    TextField(
                        value = password,
                        onValueChange = {
                            password = it
                            uiState?.password = password
                        },
                        singleLine = true,
                        label = { Text(if (isError) "Password*" else "Password") },
                        supportingText = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Contains atleast 8 characters",
                                textAlign = TextAlign.End,
                                color = Color.Gray,
                            )
                        },
                        isError = false,
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                        ),
                        keyboardActions = KeyboardActions { },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFE2E8F0),
                            textColor = Color.DarkGray,
                            unfocusedLabelColor = Color.Gray,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                    )
                    TextField(
                        value = password,
                        onValueChange = {
                            password = it
                            uiState?.password = password
                        },
                        singleLine = true,
                        label = { Text(if (isError) "Confirm Password*" else "Confirm Password") },
                        supportingText = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Should match the password",
                                textAlign = TextAlign.End,
                                color = Color.Gray,
                            )
                        },
                        isError = false,
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                        ),
                        keyboardActions = KeyboardActions { },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFE2E8F0),
                            textColor = Color.DarkGray,
                            unfocusedLabelColor = Color.Gray,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                    )
                    Column(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Button(
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color(0xFF6A9197),
                                    contentColor = Color.White,
                                    disabledContainerColor = Color(0x996A9197),
                                    disabledContentColor = Color.White,
                                ),
                                onClick = {
                                    if (password != defaultPasswd) {
                                        return@Button
                                    }
                                    nav.navigate("home") {
                                        viewModel.incrementCount()
                                        uiState?.password = ""
                                        popUpTo("home") {
                                            inclusive = true
                                        }
                                    }
                                },
                            ) {
                                Text(
                                    text = "SignUp",
                                )
                            }
                            Button(
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.Gray,
                                    disabledContainerColor = Color.Transparent,
                                    disabledContentColor = Color.Gray,
                                ),
                                onClick = {
                                    nav.navigate("login") {
                                        viewModel.incrementCount()
                                        uiState?.password = ""
                                        popUpTo("auth") {
                                            inclusive = true
                                        }
                                    }
                                },
                            ) {
                                Text(
                                    text = "Already have an account?",
                                )
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_bottom_left),
                contentDescription = "",
                modifier = Modifier.width(150.dp),
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    WebBrowserTheme {
        val nav = rememberNavController()
        val viewModel: DataViewModel = viewModel()
        Register(nav = nav, viewModel = viewModel)
    }
}
