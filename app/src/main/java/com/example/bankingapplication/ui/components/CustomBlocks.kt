package com.example.bankingapplication.ui.components

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import com.example.bankingapplication.R
import androidx.compose.ui.res.*
import androidx.compose.ui.Alignment
import androidx.compose.material3.Divider
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kotlin.text.Typography

@Composable
fun PhoneNumberBar( onPhoneNumberChanged: (String) -> Unit){
	var phoneNumber by remember { mutableStateOf("") }

	Row(
		modifier = Modifier
			.height(dimensionResource(id = R.dimen.space_50))
			.fillMaxWidth()
			.padding(
				start = dimensionResource(id = R.dimen.space_20),
				end = dimensionResource(id = R.dimen.space_20)
			)
			.background(
				colorResource(id = R.color.white),
				shape = RoundedCornerShape(dimensionResource(id = R.dimen.space_5))
			)

	){
		Box(
			modifier = Modifier
				.weight(1f)
				.fillMaxSize()
		){
			Row(
				modifier = Modifier
					.align(Alignment.Center),
				horizontalArrangement = Arrangement.SpaceBetween
			){

				Image(painter = painterResource(id = R.drawable.image_flag_arm),
					contentDescription = "country flag",
					modifier = Modifier
						.align(Alignment.CenterVertically)
						.padding(end = dimensionResource(id = R.dimen.space_2))
						.clickable {}
				)
				Text(text = "+374", style = MaterialTheme.typography.titleLarge)
			}
		}
		Divider(
			modifier = Modifier
				.fillMaxHeight()
				.width(
					dimensionResource(id = R.dimen.space_2)
				), color = colorResource(id = R.color.brown)
		)
		Box(
			modifier = Modifier
				.weight(2.3f)
				.fillMaxSize()
				.background(
					color = colorResource(id = R.color.white),
					shape = RoundedCornerShape(dimensionResource(id = R.dimen.space_5))
				)

		){
			BasicTextField(
				modifier = Modifier
					.align(Alignment.CenterStart)
					.padding(start = dimensionResource(id = R.dimen.space_5))

				,
				value = phoneNumber,
				textStyle = MaterialTheme.typography.titleLarge,
				onValueChange = {
					phoneNumber = it.filter { char -> char.isDigit() }
					onPhoneNumberChanged(it)},
				keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
				singleLine = true,
				decorationBox = { innerTextField ->
					Row(
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.SpaceBetween,
						modifier = Modifier
					) {
						//this must be called once and in any part of this lambda we want to put it
						innerTextField()
					}
				}
			)
		}
	}
}

@Composable
fun PasswordBar(onPasswordChanged: (String) -> Unit){
	var isPasswordVisible by remember { mutableStateOf(false) }
	var password by remember {mutableStateOf("")}
	val focusRequester = remember { FocusRequester() }

	Box(
		modifier = Modifier
			.padding(
				dimensionResource(id = R.dimen.space_20),
				dimensionResource(id = R.dimen.space_0)
			)
			.background(
				colorResource(id = R.color.white),
				shape = RoundedCornerShape(dimensionResource(id = R.dimen.space_5))
			)
	){
		BasicTextField(
			modifier = Modifier
				.fillMaxWidth(),
			value = password,
			textStyle = MaterialTheme.typography.titleLarge,
			onValueChange = { password = it.filter { char -> char.isLetterOrDigit() || char in "!@#$%^&*()_+-={}[];:'\",.<>/?"}
							onPasswordChanged(it)},
			visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
			singleLine = true,
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
			decorationBox = { innerTextField ->
				Row(
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.SpaceBetween,
					modifier = Modifier
						.height(dimensionResource(id = R.dimen.space_50))
						.padding(dimensionResource(id = R.dimen.space_5))
				) {
					//this must be called once and in any part of this lambda we want to put it
					innerTextField()
					val icon =
						if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
					Icon(
						imageVector = icon,
						contentDescription = "Toggle password visibility",
						tint = Color.Gray,
						modifier = Modifier
							.align(Alignment.CenterVertically)
							.padding(dimensionResource(id = R.dimen.space_5))
							.clickable {
								isPasswordVisible = !isPasswordVisible
							},
					)
				}
			}
		)
	}
}


@Composable
fun BackButton(navController: NavController,
	rout: String
)
{
		Icon(
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.space_10))
				.clickable {
					navController.navigate(rout)
				},
			painter = painterResource(id = R.drawable.ic_arrow_left),
			contentDescription = ""
		)
}

@Composable
fun AlertDialog() {
	val openDialog = remember { mutableStateOf(true) }

	if (openDialog.value) {
		AlertDialog(
			onDismissRequest = {
				// Dismiss the dialog when the user clicks outside the dialog or on the back
				// button. If you want to disable that functionality, simply use an empty
				// onDismissRequest.
//				openDialog.value = false
			},
//			icon = R.drawable.ic_temporary,
			icon = null,
			title = {
				Text(text = stringResource(id = R.string.attention))
			},
			text = {
				Text(text = stringResource(id = R.string.are_u_sure))
			},
			confirmButton = {
				TextButton(
					onClick = {
						openDialog.value = false
					}
				) {
					Text(stringResource(id = R.string.no))
				}
				TextButton(
					onClick = {
						openDialog.value = false
					}
				) {
					Text(stringResource(id = R.string.yes))
				}
			}
		)
	}
}

@Composable
fun PinCodeBar(onPinChanged: (String) -> Unit){
	var isPinVisible by remember { mutableStateOf(false) }
	var pin by remember { mutableStateOf("") }
	Box(
		modifier = Modifier
			.padding(
				dimensionResource(id = R.dimen.space_50),
				dimensionResource(id = R.dimen.space_0)
			)
			.background(
				colorResource(id = R.color.white),
				shape = RoundedCornerShape(dimensionResource(id = R.dimen.space_5))
			)
	) {
		BasicTextField(
			modifier = Modifier
				.fillMaxWidth(),
			value = pin,
			textStyle = MaterialTheme.typography.titleLarge,
			onValueChange = {
				pin = it.filterIndexed { index, _ ->
					index < 6
				}.filter { char ->
					char.isDigit()}
				onPinChanged(it)
			},
			visualTransformation = if (isPinVisible) VisualTransformation.None else PasswordVisualTransformation(),
			singleLine = true,
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
			decorationBox = { innerTextField ->
				Row(
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.SpaceBetween,
					modifier = Modifier
						.height(dimensionResource(id = R.dimen.space_50))
						.padding(dimensionResource(id = R.dimen.space_5))
				) {
					//this must be called once and in any part of this lambda we want to put it
					innerTextField()
					val icon =
						if (isPinVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
					Icon(
						imageVector = icon,
						contentDescription = "Toggle password visibility",
						tint = Color.Gray,
						modifier = Modifier
							.align(Alignment.CenterVertically)
							.padding(dimensionResource(id = R.dimen.space_5))
							.clickable {
								isPinVisible = !isPinVisible
							},

						)
				}
			}
		)
	}
}

//home screen
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TopBar(){
	Row(
		modifier = Modifier.fillMaxWidth()
	){
		Image(painter = painterResource(id = R.drawable.ic_temporary),
			contentDescription = "",
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.space_10))
				.align(
					Alignment.CenterVertically
				)
		)
		Column(
		){
			Text(
				text = stringResource(id = R.string.name),
				style = MaterialTheme.typography.titleLarge,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.space_1)),
			)
			Text(
				text = stringResource(id = R.string.role),
				style = MaterialTheme.typography.labelLarge,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.space_1))
					.align(
						Alignment.CenterHorizontally
					)

			)
		}
		Image(painter = painterResource(id = R.drawable.ic_notification),
			contentDescription = "",
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.space_10))
				.align(
					Alignment.CenterVertically
				)
			)
	}

}