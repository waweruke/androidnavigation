package com.example.navigationapp.ui.theme.pages.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.ui.theme.NavigationAppTheme

@Composable
fun SignupScreen(navController:NavHostController) {
    Text(text = "Welcome to signup screen")
}

@Preview
@Composable
fun SignupScreenPreview() {
    NavigationAppTheme {
        SignupScreen(rememberNavController())
    }
}