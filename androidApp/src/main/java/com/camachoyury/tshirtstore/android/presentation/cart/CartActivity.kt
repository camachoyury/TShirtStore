package com.camachoyury.tshirtstore.android.presentation.cart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.camachoyury.tshirtstore.android.App

import com.camachoyury.tshirtstore.android.data.repository.Shirt

import com.camachoyury.tshirtstore.android.presentation.cart.ui.theme.TShirtStoreTheme
import com.camachoyury.tshirtstore.android.presentation.composables.ShirtStoreToolBar

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TShirtStoreTheme {
                Content()
            }
        }
    }
}


@Composable
fun Content(){

    Scaffold(
        topBar = { ShirtStoreToolBar()  },
        drawerContent = { androidx.compose.material.Text(text = "drawerContent") },
        content = {
            val list = App.emulatedDB
            LazyColumn(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp)) {
                items(items = list, itemContent = { item ->
                    ShoppingCartItem(item)
                    Divider(color = Color.Black)
                })
            }

        },
        bottomBar = {
            Button(modifier = Modifier.height(56.dp)
                .fillMaxWidth()
                .padding(bottom = 15.dp, start = 10.dp, end = 10.dp) , onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Black
            )) {
                Text("Buy ", color = Color.White)
            }
        }
    )
}


@Composable
fun ShoppingCartItem(shirt: Shirt) {
    val context = LocalContext.current
    val imageUri = "@drawable/${shirt.image}"
    val imageResource =
        context.resources.getIdentifier(imageUri, null, context.packageName)

    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier.size(100.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(
                painterResource(imageResource),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize())
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(shirt.title, fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("${shirt.price} $", style = MaterialTheme.typography.body2,modifier = Modifier.align(
                    Alignment.End))
            }
        }


    }

}