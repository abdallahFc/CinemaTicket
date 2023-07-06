package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicket.ui.theme.DarkGray
import com.example.cinematicket.ui.theme.Gray
import com.example.cinematicket.states.Day


@Composable
fun DateItem(
    date: String = "",
    day: String = "",
    isSelected: Boolean = false,
    doWhenSelectDay: (Day) -> Unit,
) {
    val color = if (isSelected) DarkGray else Color.White
    val textColor = if (isSelected) Color.White else Color.Black
    val secondaryTextColor = if (isSelected) Color.White else Color.Gray
    Column(
        modifier = Modifier
            .border(0.5.dp, Gray, RoundedCornerShape(16.dp))
            .clickable { doWhenSelectDay(Day(date.toInt(), day)) }
            .background(color, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = date,
            fontSize = 16.sp,
            color = textColor,
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            text = day,
            color = secondaryTextColor,
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}
