package com.example.bankingapplication.ui.screens.first
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import com.example.bankingapplication.R
import androidx.compose.ui.res.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavController


@Composable
fun LanguageScreen(navController: NavController){
	val languages = listOf("English", "Spanish", "French", "German", "Italian", "Japanese", "Chinese")
	var selectedLanguage by remember { mutableStateOf("English") }

	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.background)
	) {
		Column(

			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			LazyColumn {
				items(languages.size) { index ->
					val language = languages[index]
					LanguageItem(
						language = language,
						isSelected = language == selectedLanguage,
						onLanguageSelected = { selectedLanguage = it }
					)
				}
			}
		}
	}
}

@Composable
fun LanguageItem(
	language: String,
	isSelected: Boolean,
	onLanguageSelected: (String) -> Unit
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.clickable { onLanguageSelected(language) },
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Text(
			text = language,
			style = MaterialTheme.typography.titleMedium.copy(
				color = if (isSelected) MaterialTheme.colorScheme.primary else colorResource(id = R.color.black)
			)
		)
		if (isSelected){
			Image(painter = painterResource(id = R.drawable.ic_temporary), contentDescription = "")
		}
	}
}

