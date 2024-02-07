package com.example.bankingapplication.ui.screens.first

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import com.example.bankingapplication.R
import androidx.compose.ui.res.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.example.bankingapplication.ui.components.EntryStatusBarStyle
import com.example.bankingapplication.ui.components.Screens
import kotlinx.coroutines.delay


@Composable
fun EntryScreen(navController: NavHostController) {

	LaunchedEffect(Unit) {
		delay(2000)
		navController.navigate(Screens.LogInScreen.name)
	}
	EntryStatusBarStyle()
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(colorResource(id = R.color.orange))
	) {
		Box(
			Modifier
				.weight(1f)
				.fillMaxSize()) {
			Image(
				modifier = Modifier.align(Alignment.BottomCenter),
				painter = painterResource(
					id = R.drawable.image_logo_transparent

				),
				contentDescription = "App Logo"
			)
		}
		Box(
			Modifier
				.weight(1f)
				.fillMaxSize()) {
			Column(
				modifier =Modifier.fillMaxSize(),
				verticalArrangement = Arrangement.SpaceEvenly,
				horizontalAlignment = Alignment.CenterHorizontally
			)
			{
				Text(
					text = stringResource(id = R.string.idram_and_idBank),
					color = colorResource(id = R.color.white),
					style = MaterialTheme.typography.headlineLarge
				)
				Text(
					text = stringResource(id = R.string.connecting),
					color = colorResource(id = R.color.white),
					style = MaterialTheme.typography.titleSmall
				)
			}
		}
	}
}