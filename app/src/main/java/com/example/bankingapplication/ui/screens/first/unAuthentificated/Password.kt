package com.example.bankingapplication.ui.screens.first.unAuthentificated

import android.view.ViewTreeObserver
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.bankingapplication.R
import androidx.compose.ui.res.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.bankingapplication.ui.components.BackButton
import com.example.bankingapplication.ui.components.CommonStatusBarStyle
import com.example.bankingapplication.ui.components.PasswordBar
import com.example.bankingapplication.ui.components.Screens


@Composable
fun PasswordScreen(navController: NavHostController) {
	var enteredPassword by remember { mutableStateOf("") }
	var isKeyboardVisible by remember { mutableStateOf(false) }
	val context = LocalContext.current
	val rootView = LocalView.current

	CommonStatusBarStyle()
	DisposableEffect(context) {
		val onGlobalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
			val rect = android.graphics.Rect()
			rootView.getWindowVisibleDisplayFrame(rect)
			val screenHeight = rootView.height

			// Check if the height difference is smaller than a threshold
			isKeyboardVisible = screenHeight - rect.bottom > screenHeight * 0.15
		}
		rootView.viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener)
		onDispose {
			rootView.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener)
		}
	}

	Column (
		modifier = Modifier
			.fillMaxSize()
			.background(colorResource(id = R.color.brown))
	){
		Box(
			modifier = Modifier
				.weight(if (isKeyboardVisible) 0.7f else 1f)
				.fillMaxSize(),
		){
			Row(
				modifier = Modifier
					.fillMaxSize(),
				horizontalArrangement = Arrangement.SpaceBetween
			){
				BackButton(navController, Screens.LogInScreen.name)
				Text(text = stringResource(id = R.string.eng),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.space_10))
					.clickable { navController.navigate(Screens.LanguageScreen.name) })
			}
		}
		Column (
			modifier = Modifier
				.weight(3.5f)
				.padding(
					top = dimensionResource(id = R.dimen.space_20),
					bottom = dimensionResource(id = R.dimen.space_20)
				)
				.fillMaxSize(),
			verticalArrangement = Arrangement.SpaceBetween,
			horizontalAlignment = Alignment.CenterHorizontally
		){
			Column (
				modifier = Modifier.weight(1f)
			){
				Text(text = stringResource(
					id = R.string.password),
					style = MaterialTheme.typography.titleLarge,
					modifier = Modifier.align(
						Alignment.CenterHorizontally
					))
				Text(text = stringResource(id = R.string.enter_the_password),
					modifier = Modifier
						.padding(
							start = dimensionResource(id = R.dimen.space_50),
							end = dimensionResource(id = R.dimen.space_50)
						),
					style = MaterialTheme.typography.labelSmall,
					textAlign = TextAlign.Center
				)
			}
			Column(
				modifier = Modifier.weight(1f)
			){
			PasswordBar(onPasswordChanged = { enteredPassword = it})}
			Column (
				modifier = Modifier.weight(if (isKeyboardVisible) 2.4f else 0.5f)
			){
				Text(
					text = stringResource(id = R.string.if_u_dont_remember),
					style = MaterialTheme.typography.labelMedium,
					modifier = Modifier.align(
						Alignment.CenterHorizontally
					))
				Text(
					text = stringResource(id = R.string.reset_password),
					color = colorResource(id = R.color.blue),
					style = MaterialTheme.typography.labelSmall,
					modifier = Modifier
						.align(Alignment.CenterHorizontally)
						.clickable {
							navController.navigate(Screens.RecoverPasswordScreen.name)
						}
				)
				Button(
					onClick = {
						if(enteredPassword.isNotBlank()) {
							navController.navigate(Screens.PinCodeScreen.name)
						}
							  },
					colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange)),
					modifier = Modifier
						.fillMaxWidth()
						.padding(dimensionResource(id = R.dimen.space_20))
						.align(Alignment.CenterHorizontally),
				enabled = enteredPassword.length > 7)
				{
					Text(
						text = stringResource(id = R.string.next),
						style = MaterialTheme.typography.titleMedium,
						modifier = Modifier
					)
				}
			}
		}
	}
}