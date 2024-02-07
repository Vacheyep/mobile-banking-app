package com.example.bankingapplication.ui.screens.first.unAuthentificated

import android.app.Activity
import android.view.ViewTreeObserver
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.bankingapplication.R
import androidx.compose.runtime.*
import androidx.compose.ui.res.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.bankingapplication.ui.components.PhoneNumberBar
import com.example.bankingapplication.ui.components.Screens

import androidx.compose.ui.platform.*
import com.example.bankingapplication.ui.components.CommonStatusBarStyle
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LogInOrSignUpScreen(
	navController: NavHostController
) {
	var enteredPhoneNumber by remember { mutableStateOf("") }
	var isKeyboardVisible by remember { mutableStateOf(false) }
	val context = LocalContext.current
	val rootView = LocalView.current

	CommonStatusBarStyle()
	BackHandler() {
		// Handle back button press here
		// You can use the following code to close the app:
		 (context as? Activity)?.finish()
		// or use the System.exit(0) method
		// Note: Closing the app programmatically is generally discouraged in Android
	}

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
			Text(text = stringResource(id = R.string.eng),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.align(Alignment.TopEnd)
					.padding(dimensionResource(id = R.dimen.space_10))
					.clickable { navController.navigate(Screens.LanguageScreen.name) })
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
					id = R.string.log_in_or_sign_up),
					style = MaterialTheme.typography.titleLarge,
					modifier = Modifier.align(
					Alignment.CenterHorizontally
				))
				Text(text = stringResource(id = R.string.lets_get_started),
					style = MaterialTheme.typography.labelMedium,
					modifier = Modifier
						.padding(
							start = dimensionResource(id = R.dimen.space_50),
							end = dimensionResource(id = R.dimen.space_50)
						),
							textAlign = TextAlign.Center
				)
			}
			Column(
				modifier = Modifier.weight(1f)
			) {
				PhoneNumberBar(onPhoneNumberChanged = { enteredPhoneNumber = it })
				if(enteredPhoneNumber.length == 8){
					Row(

						modifier = Modifier.align(Alignment.CenterHorizontally)
					){
						Image(painterResource(id = R.drawable.ic_check_circle), contentDescription = "")
					Text(
						text = stringResource(id = R.string.you_can_continue),
						style = MaterialTheme.typography.labelSmall,
						)
					}
				}
			}
			Column (
				modifier = Modifier.weight(if (isKeyboardVisible) 2.1f else 0.5f)
			){
				Text(
					text = stringResource(id = R.string.by_tapping_etc),
					style = MaterialTheme.typography.labelMedium,
					modifier = Modifier.align(
					Alignment.CenterHorizontally
				))
				Text(
					text = stringResource(id = R.string.public_agreement),
					color = colorResource(id = R.color.blue),
					style = MaterialTheme.typography.labelMedium,
					modifier = Modifier
						.align(Alignment.CenterHorizontally)
						.clickable {}
				)
				Button(
					onClick = {
						if (enteredPhoneNumber.isNotBlank()) {
							navController.navigate(Screens.PasswordScreen.name)
						}
					},
					colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange)),
					modifier = Modifier
						.fillMaxWidth()
						.padding(dimensionResource(id = R.dimen.space_20))
						.align(Alignment.CenterHorizontally),
					enabled = enteredPhoneNumber.length == 8)
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