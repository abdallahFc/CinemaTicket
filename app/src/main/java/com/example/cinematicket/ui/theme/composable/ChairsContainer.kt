package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicket.R
import com.example.cinematicket.ui.theme.DarkGray
import com.example.cinematicket.ui.theme.Orange
import com.example.cinematicket.updateState

import com.example.cinematicket.states.ChairState

@Composable
fun ChairsContainer(
    chairStates: List<ChairState>,
    modifier: Modifier = Modifier
) {
    var states by remember {
        mutableStateOf(chairStates)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.chair_container),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = getPairTint(states)
        )
        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            ChairItem(chairState = states[0]) {
                states = states.toMutableList().apply { set(0, it.updateState()) }
            }
            ChairItem(chairState = states[1]) {
                states = states.toMutableList().apply { set(1, it.updateState()) }
            }
        }
    }
}

@Composable
private fun getPairTint(chairStates: List<ChairState>): Color {
    return when {
        chairStates.all { it == ChairState.Selected } -> Orange.copy(alpha = 0.4f)
        chairStates.all { it == ChairState.Taken } -> DarkGray.copy(alpha = 0.2f)
        else -> DarkGray.copy(alpha = 0.6f)
    }
}

