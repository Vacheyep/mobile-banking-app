package com.example.bankingapplication.ui.screens.second

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.bankingapplication.R
import com.example.bankingapplication.ui.components.HomeStatusBarStyle
import com.example.bankingapplication.ui.components.TopBar


@Composable
fun HomeScreen(modifier: Modifier, navController: NavHostController) {
    HomeStatusBarStyle()
    Column(
        modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.brown))
    ) {
        TopBar()
//        CustomButton(text: String,navController)
//        Stories(navController)
//
//        BankCardsRow(navController)
//        GroupsBar(navController)
//        BottomBar(navController)
    }
}