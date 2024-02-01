package com.example.bankingapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// displayLarge
// displayMedium
// displaySmall
// headlineLarge
// headlineMedium
// headlineSmall
// titleLarge
// titleMedium
// titleSmall
// bodyLarge
// bodyMedium
// bodySmall
// labelLarge
// labelMedium
// labelSmall
val Typography = Typography(
	bodyLarge = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 80.sp,
        letterSpacing = 0.sp
    ),

	labelLarge = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 11.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	),
	labelMedium = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 12.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	),
	labelSmall = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 12.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
)

)