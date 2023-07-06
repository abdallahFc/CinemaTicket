package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicket.ui.theme.DarkGray
import com.example.cinematicket.ui.theme.Gray

@Composable
fun DateItem(
    time: String = "",
    isSelected: Boolean = false,
    doWhenSelectHour: (String) -> Unit,
) {
    val color = if (isSelected) DarkGray else Color.White
    val textColor = if (isSelected) Color.White else Color.Black
    Column(
        modifier = Modifier
            .border(0.5.dp, Gray, RoundedCornerShape(16.dp))
            .clickable { doWhenSelectHour(time) }
            .background(color, RoundedCornerShape(16.dp))
    ) {
        Text(
            text = time,
            fontSize = 14.sp,
            color = textColor,
            modifier = Modifier.padding(8.dp)
        )
    }

}
