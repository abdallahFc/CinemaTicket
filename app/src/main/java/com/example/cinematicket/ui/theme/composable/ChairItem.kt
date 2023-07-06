package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicket.R
import com.example.cinematicket.ui.theme.DarkGray
import com.example.cinematicket.ui.theme.Orange
import com.example.cinematicket.ui.theme.TextWhite
import com.example.cinematicket.states.ChairState


@Composable
fun ChairItem(
    chairState: ChairState,
    onClickChair: (ChairState) -> Unit,
) {
    val tintColor =getTint(chairState)

    Box(
        modifier = Modifier.size(35.dp),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            modifier = Modifier.fillMaxSize(),
            onClick = { onClickChair(chairState) },
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.chair),
                contentDescription = null,
                tint = tintColor,

            )
        }
    }
}
@Composable
private fun getTint(chairStates: ChairState): Color {
    return  when (chairStates) {
        ChairState.Available -> TextWhite
        ChairState.Taken -> DarkGray
        ChairState.Selected -> Orange
    }
}

