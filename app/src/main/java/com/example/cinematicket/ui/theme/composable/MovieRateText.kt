package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.cinematicket.ui.theme.Black40
import com.example.cinematicket.ui.theme.Black80
import com.example.cinematicket.ui.theme.Sans

@Composable
fun MovieRateText(
    title: String = "",
    subtitle: String = "",
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontFamily = Sans,
            color = Black80,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = subtitle,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Black40,
            fontFamily = Sans,
            fontWeight = FontWeight.Medium
        )
    }
}