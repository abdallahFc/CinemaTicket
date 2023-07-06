package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicket.ui.theme.Sans

@Composable
fun ColorBoxWithText(
    color: Color,
    text: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(color)
                .align(Alignment.CenterVertically)
        )
        SpacerHorizontal8()
        Text(
            text = text,
            fontFamily = Sans,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}
