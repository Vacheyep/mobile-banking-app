package com.example.bankingapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.res.colorResource
import com.example.bankingapplication.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CommonStatusBarStyle(){
    val statusBarColor = colorResource(id = R.color.brown2)
    val navigationBarColor = colorResource(id = R.color.brown2)
    val systemUiController = rememberSystemUiController()

    SideEffect {
        // Update the status bar and navigation bar color when the composable is first composed
        systemUiController.setStatusBarColor(statusBarColor)
        systemUiController.setNavigationBarColor(navigationBarColor)
    }
}
@Composable
fun EntryStatusBarStyle(){
    val statusBarColor = colorResource(id = R.color.orange)
    val navigationBarColor = colorResource(id = R.color.orange)
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
        systemUiController.setNavigationBarColor(navigationBarColor)
    }
}
@Composable
fun HomeStatusBarStyle(){
    val statusBarColor = colorResource(id = R.color.orange)
    val navigationBarColor = colorResource(id = R.color.brown3)
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
        systemUiController.setNavigationBarColor(navigationBarColor)
    }
}