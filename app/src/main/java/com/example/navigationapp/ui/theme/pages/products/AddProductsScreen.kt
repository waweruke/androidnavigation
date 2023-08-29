package com.example.navigationapp.ui.theme.pages.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.data.AuthRepository
import com.example.navigationapp.data.ProductRepository
import com.example.navigationapp.navigation.ROUTE_LOGIN
import com.example.navigationapp.ui.theme.NavigationAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add product",
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold)

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productQuality by remember { mutableStateOf(TextFieldValue("")) }
        var productPrice by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = productName,
            onValueChange = {productName = it},
            label ={ Text(text = "Name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productQuality,
            onValueChange = {productQuality = it},
            label ={ Text(text = "Email *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = productPrice,
            onValueChange = {productPrice = it},
            label ={ Text(text = "Password *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //------WRITE SAVE LOGIC HERE-----//
            var productRepository = ProductRepository(navController,context)
            productRepository.saveProduct(productName.text.trim(),productQuality.text.trim(),productPrice.text.trim())

        }) {
            Text(text = "Save")
        }




    }
}

@Preview
@Composable
fun AddProductsScreenPreview() {
    NavigationAppTheme {
        AddProductsScreen(rememberNavController())
    }
}