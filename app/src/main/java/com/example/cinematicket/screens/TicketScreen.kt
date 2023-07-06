package com.example.cinematicket.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicket.R
import com.example.cinematicket.ui.theme.DarkGray
import com.example.cinematicket.ui.theme.Gray
import com.example.cinematicket.ui.theme.Orange
import com.example.cinematicket.ui.theme.TextWhite
import com.example.cinematicket.ui.theme.composable.ColorBoxWithText
import com.example.cinematicket.ui.theme.composable.DateItem
import com.example.cinematicket.ui.theme.composable.IconButton
import com.example.cinematicket.ui.theme.composable.RowOfChairs
import com.example.cinematicket.ui.theme.composable.SpacerVertical16
import com.example.cinematicket.states.ChairState
import com.example.cinematicket.states.Day
import com.example.cinematicket.states.TicketsUiState

@Composable
fun TicketScreen() {
    var ticketsUiState by remember { mutableStateOf(TicketsUiState()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF010101))
            .padding(16.dp)
    ) {
        Header()
        TicketContent()
        ChairState()
        Spacer(modifier = Modifier.weight(1f))
        BottomSheet(ticketsUiState, doWhenSelectDay = {
            ticketsUiState = ticketsUiState.copy(selectedDay = it)
        }, doWhenSelectHour = {
            ticketsUiState = ticketsUiState.copy(selectedTime = it)
        })


    }
}

@Composable
private fun Header() {
    IconButton(
        painter = R.drawable.close_circle
    ) {}
    SpacerVertical16()
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.15f),
        painter = painterResource(id = R.drawable.img),
        contentDescription = null,
    )
}
@Composable
fun ChairState() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        ColorBoxWithText(color = TextWhite, text = stringResource(R.string.available))
        ColorBoxWithText(color = DarkGray, text = stringResource(R.string.taken))
        ColorBoxWithText(color = Orange, text = stringResource(R.string.selected))
    }
}
@Composable
fun TicketContent() {
    Box {
        val paddingStep = 48
        val numColumns = 5
        repeat(numColumns) { index ->
            val topPadding = (index * paddingStep).dp
            Column(modifier = Modifier.padding(top = topPadding)) {
                RowOfChairs(
                    chairsList = listOf(
                        listOf(ChairState.Selected, ChairState.Available),
                        listOf(ChairState.Selected, ChairState.Selected),
                        listOf(ChairState.Taken, ChairState.Taken),
                    )
                )
            }
        }
    }
}

@Composable
fun BottomSheet(
    state: TicketsUiState,
    doWhenSelectDay: (Day) -> Unit,
    doWhenSelectHour: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Color.White)
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(top = 32.dp, end = 16.dp, start = 16.dp, bottom = 16.dp)
        ) {
            items(state.days) {
                DateItem(
                    date = it.dayNumber.toString(),
                    day = it.dayName,
                    isSelected = it == state.selectedDay,
                    doWhenSelectDay
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(state.timeList) {
                DateItem(time = it, isSelected = it == state.selectedTime, doWhenSelectHour)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = stringResource(R.string.price), color = Color.Black, fontSize = 22.sp)
                Text(text = stringResource(R.string.tickets), color = Gray, fontSize = 12.sp)
            }
            IconButton(
                painter = R.drawable.card,
                backgroundColor = Orange,
                text = stringResource(R.string.buy_tickets)
            ) {}
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TicketScreenPreview() {
    TicketScreen()
}
