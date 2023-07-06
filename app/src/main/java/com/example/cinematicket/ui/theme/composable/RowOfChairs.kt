package com.example.cinematicket.ui.theme.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinematicket.states.ChairState


@Composable
fun RowOfChairs(
    chairsList: List<List<ChairState>>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        repeat(chairsList.size) {
            ChairsContainer(
                chairStates = chairsList[it],
                modifier = Modifier.graphicsLayer {
                    rotationZ = if (it == 0) 12f else if (it == 1) 0f else -12f
                    translationY = if (it == 1) 30f else 0f
                },
            )
        }
    }
}

