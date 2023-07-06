package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicket.ui.theme.Black80
import com.example.cinematicket.ui.theme.Gray
import com.example.cinematicket.ui.theme.Sans

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    buttonColor : Color = Color.Transparent,
    textColor : Color = Black80,
    text: String = "",
    textSize: Int = 12,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        border = BorderStroke(0.5.dp, Gray),
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        Text(
            text = text,
            fontSize = textSize.sp,
            color = textColor,
            fontFamily = Sans,
            fontWeight = FontWeight.Normal
        )
    }
}