package com.example.bankingapplication.ui.screens.first.unAuthentificated

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.bankingapplication.R
import androidx.compose.ui.res.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.bankingapplication.ui.components.BackButton
import com.example.bankingapplication.ui.components.CommonStatusBarStyle
import com.example.bankingapplication.ui.components.PinCodeBar
import com.example.bankingapplication.ui.components.Screens


@Composable
fun PinCodeScreen(navController: NavHostController) {
	var enteredPin by remember { mutableStateOf("") }
	CommonStatusBarStyle()
	Column (
		modifier = Modifier
			.fillMaxSize()
			.background(colorResource(id = R.color.brown))
	){
		Box(
			modifier = Modifier
				.weight(1f)
				.fillMaxSize(),
		){
			BackButton(navController, Screens.PasswordScreen.name)//must open Alert dialog
			Text(text = stringResource(id = R.string.eng),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.align(Alignment.TopEnd)
					.padding(dimensionResource(id = R.dimen.space_10))
					.clickable { navController.navigate(Screens.LanguageScreen.name) })
		}
		Column (
			modifier = Modifier
				.weight(3f)
				.padding(
					top = dimensionResource(id = R.dimen.space_20),
					bottom = dimensionResource(id = R.dimen.space_20)
				)
				.fillMaxSize(),
			verticalArrangement = Arrangement.SpaceBetween,
			horizontalAlignment = Alignment.CenterHorizontally
		){
			Column (){
				Text(text = stringResource(
					id = R.string.pin_code),
					style = MaterialTheme.typography.titleLarge,
					modifier = Modifier.align(
						Alignment.CenterHorizontally
					))
				Text(text = stringResource(id = R.string.enter_the_pin),
					modifier = Modifier
						.padding(
							start = dimensionResource(id = R.dimen.space_50),
							end = dimensionResource(id = R.dimen.space_50)
						),
					textAlign = TextAlign.Center
				)
			}
			PinCodeBar(onPinChanged = { enteredPin = it})
			Column (){
				Text(
					text = stringResource(id = R.string.reset_pin_code),
					color = colorResource(id = R.color.blue),
					style = MaterialTheme.typography.labelMedium,
					modifier = Modifier
						.align(Alignment.CenterHorizontally)
						.clickable { navController.navigate(Screens.RecoverPinCodeScreen.name) }
				)
				Button(
					onClick = { navController.navigate(Screens.HomeScreen.name)},
					colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange)),
					modifier = Modifier
						.fillMaxWidth()
						.padding(dimensionResource(id = R.dimen.space_20))
						.align(Alignment.CenterHorizontally),
				enabled = enteredPin.length > 5)

				{
					Text(
						text = stringResource(id = R.string.confirm),
						style = MaterialTheme.typography.titleMedium,
						modifier = Modifier
					)
				}
			}
		}
	}
}


