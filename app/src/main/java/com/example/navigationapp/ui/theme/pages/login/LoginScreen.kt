package com.example.navigationapp.ui.theme.pages.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.navigation.ROUTE_ABOUT
import com.example.navigationapp.navigation.ROUTE_HOME
import com.example.navigationapp.navigation.ROUTE_SIGNUP
import com.example.navigationapp.ui.theme.NavigationAppTheme

@Composable
fun LoginScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to login screen")
        Button(onClick = { navController.navigate(ROUTE_SIGNUP) }) {
            Text(text = "Go to signup screen")
        }

        Button(onClick = { navController.navigate(ROUTE_HOME) }) {
            Text(text = "Go to home screen")
        }

        Button(onClick = { navController.navigate(ROUTE_ABOUT) }) {
            Text(text = "Go to about screen")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    NavigationAppTheme {
        LoginScreen(rememberNavController())
    }
}