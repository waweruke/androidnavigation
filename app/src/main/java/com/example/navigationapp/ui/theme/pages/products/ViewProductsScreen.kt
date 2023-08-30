package com.example.navigationapp.ui.theme.pages.products

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.data.ProductRepository
import com.example.navigationapp.navigation.ROUTE_UPDATE_PRODUCTS
import com.example.navigationapp.ui.theme.NavigationAppTheme

@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "All products",
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        var context = LocalContext.current
        var productRepository = ProductRepository(navController, context)
        var products = productRepository.viewProducts()
        LazyColumn(){
            items(products.count()){
                var productName = products.get(it).name
                var productQuantity = products.get(it).quantity
                var productPrice = products.get(it).price
                var id = products.get(it).id
                ProductItem(
                    name = productName,
                    quantity = productQuantity,
                    price = productPrice,
                    id = id,
                    productRepository = productRepository ,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String, productRepository: ProductRepository, navController: NavHostController) {
    Column(modifier =  Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

@Preview
@Composable
fun viewProductsScreenPreview() {
    NavigationAppTheme {
        ViewProductsScreen(rememberNavController())
    }
}