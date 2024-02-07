package com.example.bankingapplication.ui.components

import androidx.annotation.StringRes
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bankingapplication.R
import com.example.bankingapplication.ui.screens.first.EntryScreen
import com.example.bankingapplication.ui.screens.second.HomeScreen
import com.example.bankingapplication.ui.screens.first.LanguageScreen
import com.example.bankingapplication.ui.screens.first.authentificated.AuthorizationScreen
import com.example.bankingapplication.ui.screens.first.authentificated.RecoverPinCodeScreen
import com.example.bankingapplication.ui.screens.first.unAuthentificated.LogInOrSignUpScreen
import com.example.bankingapplication.ui.screens.first.unAuthentificated.PasswordScreen
import com.example.bankingapplication.ui.screens.first.unAuthentificated.PinCodeScreen
import com.example.bankingapplication.ui.screens.first.unAuthentificated.RecoverPasswordScreen

enum class Screens (@StringRes val title: Int){
	EntryScreen(title = R.string.entry_screen),
	LogInScreen(title = R.string.log_in_screen),
	PasswordScreen(title = R.string.password_screen),
	PinCodeScreen(title = R.string.pin_code),
	AuthorizationScreen(title = R.string.authorization_screen),
	HomeScreen(title = R.string.home_screen),
	LanguageScreen(title = R.string.language_screen),
	RecoverPasswordScreen(title = R.string.recover_password),
	RecoverPinCodeScreen(title = R.string.recover_pin_code)
}

@Composable
fun AppNavigation(modifier: Modifier, navController: NavHostController = rememberNavController()
) {

	NavHost(
		navController = navController,
		startDestination = Screens.EntryScreen.name
	) {
		composable(route = Screens.EntryScreen.name) {
			EntryScreen(navController)
		}
		composable(Screens.LogInScreen.name) {
			LogInOrSignUpScreen(navController)
		}
		composable(Screens.PasswordScreen.name) {
			PasswordScreen(navController)
		}
		composable(Screens.PinCodeScreen.name) {
			PinCodeScreen(navController)
		}
		composable(Screens.AuthorizationScreen.name) {
			AuthorizationScreen(navController)
		}
		composable(Screens.HomeScreen.name) {
			HomeScreen(modifier, navController)
		}
		composable(Screens.LanguageScreen.name) {
			LanguageScreen(navController)
		}
		composable(Screens.RecoverPasswordScreen.name) {
			RecoverPasswordScreen(navController)
		}
		composable(Screens.RecoverPinCodeScreen.name) {
			RecoverPinCodeScreen(navController)
		}
	}
}