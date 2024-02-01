package com.example.bankingapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bankingapplication.ui.components.AppNavigation
import com.example.bankingapplication.ui.theme.BankingApplicationTheme
import android.content.pm.ActivityInfo

//
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.*
//import androidx.compose.ui.platform.LocalDensity.currentDensity
//import androidx.compose.ui.platform.LocalDensityOwner
//import androidx.compose.ui.platform.LocalWindowInsets
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalSoftwareKeyboardController
//import androidx.compose.ui.platform.LocalSoftwareKeyboardControllerProvider
//import androidx.compose.ui.platform.LocalTextInputServiceObserver
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
		setContent {
			BankingApplicationTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					AppNavigation(modifier = Modifier)
				}
			}
		}
	}
}

//
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun MyApp() {
//	var text by remember { mutableStateOf("Hello, World!") }
//	var isKeyboardVisible by remember { mutableStateOf(false) }
//
//	val context = LocalContext.current
//	val softwareKeyboardController = LocalSoftwareKeyboardController.current
//
//	Column(
//		modifier = Modifier
//			.fillMaxSize()
//			.background(Color.Gray)
//			.padding(16.dp)
//	) {
//		TextField(
//			value = text,
//			onValueChange = {
//				text = it
//				// Check if the keyboard is visible when the text changes
//				isKeyboardVisible = softwareKeyboardController?.isSoftwareKeyboardVisible == true
//			},
//			label = { Text("Enter text") },
//			keyboardOptions = KeyboardOptions.Default.copy(
//				keyboardType = KeyboardType.Text,
//				imeAction = ImeAction.Done
//			),
//			keyboardActions = KeyboardActions(
//				onDone = {
//					softwareKeyboardController?.hide()
//				}
//			),
//			modifier = Modifier
//				.fillMaxWidth()
//				.onGloballyPositioned {
//					// Check if the keyboard is visible when the layout is repositioned
//					isKeyboardVisible = softwareKeyboardController?.isSoftwareKeyboardVisible == true
//				}
//		)
//
//		Spacer(modifier = Modifier.height(16.dp))
//
//		Text("Is Keyboard Visible: $isKeyboardVisible")
//	}
//}
