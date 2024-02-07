package com.example.bankingapplication.ui.screens.first.authentificated

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import com.example.bankingapplication.R
import androidx.compose.ui.res.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.example.bankingapplication.ui.components.BackButton
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import com.example.bankingapplication.ui.components.CommonStatusBarStyle
import com.example.bankingapplication.ui.components.Screens


@Composable
fun RecoverPinCodeScreen(navController: NavController){
	CommonStatusBarStyle()
	Column (
		modifier = Modifier
			.fillMaxSize()
			.background(colorResource(id = R.color.brown))
	){
		Row (){
			BackButton(navController, Screens.PinCodeScreen.name)
			Text(
				text = stringResource(id = R.string.recover_pin_code),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.space_10))
			)

		}
		Column (
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.space_20))
				.background(colorResource(id = R.color.brown1),shape = RoundedCornerShape(
					dimensionResource(id = R.dimen.space_20)),

		)
		){
			Text(
				text = stringResource(id = R.string.a_verifi_code),
				modifier = Modifier
					.padding(
						top = dimensionResource(id = R.dimen.space_10),
						start = dimensionResource(id = R.dimen.space_50),
						end = dimensionResource(id = R.dimen.space_50)
					),
				textAlign = TextAlign.Center
			)
			Text(
				text = "Current Phone",
				style = MaterialTheme.typography.titleLarge,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.space_10))
					.align(
						Alignment.CenterHorizontally
					)
			)
		}
		Button(
			onClick = { /*TODO*/ },
			colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange)),
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.space_20))
				.align(Alignment.CenterHorizontally)) {
			Text(
				text = stringResource(id = R.string.get_the_code),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier
			)
		}
	}
}

@Preview
@Composable
fun RecoverPinCodeScreenContent() {
	CommonStatusBarStyle()
	Column (
		modifier = Modifier
			.fillMaxSize()
			.background(colorResource(id = R.color.brown))
	){
		Row (){
			Text(
				text = stringResource(id = R.string.recover_pin_code),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.space_10))
			)

		}
		Column (
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.space_20))
				.background(colorResource(id = R.color.brown1),shape = RoundedCornerShape(
					dimensionResource(id = R.dimen.space_20)),

					)
		){
			Text(
				text = stringResource(id = R.string.a_verifi_code),
				modifier = Modifier
					.padding(
						top = dimensionResource(id = R.dimen.space_10),
						start = dimensionResource(id = R.dimen.space_50),
						end = dimensionResource(id = R.dimen.space_50)
					),
				textAlign = TextAlign.Center
			)
			Text(
				text = "Current Phone",
				style = MaterialTheme.typography.titleLarge,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.space_10))
					.align(
						Alignment.CenterHorizontally
					)
			)
		}
		Button(
			onClick = { /*TODO*/ },
			colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange)),
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.space_20))
				.align(Alignment.CenterHorizontally)) {
			Text(
				text = stringResource(id = R.string.get_the_code),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier
			)
		}
	}
}