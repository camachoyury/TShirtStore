package com.camachoyury.tshirtstore.android.presentation.composables

import android.content.Intent
import androidx.compose.adapters.ComposeViewAdapter
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camachoyury.tshirtstore.android.R
import com.camachoyury.tshirtstore.android.presentation.cart.ShoppingCartActivity
import com.camachoyury.tshirtstore.android.presentation.cart.ui.theme.TShirtStoreTheme


@Composable
fun ShirtStoreToolBar(){
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(
                text = "Shirt Store",
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu,contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = {  context.startActivity(Intent(context, ShoppingCartActivity::class.java)) }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "", tint = Color.White)
            }
        },
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White,
        elevation = 12.dp
    )
}

@Preview(showBackground = true)
@Composable
fun  DefaultPreview(){
    TShirtStoreTheme{
        ShirtStoreToolBar()
    }


}