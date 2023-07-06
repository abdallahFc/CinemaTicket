package com.example.cinematicket.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematicket.R
import com.example.cinematicket.states.HomeUIState
import com.example.cinematicket.ui.theme.Black80
import com.example.cinematicket.ui.theme.Orange
import com.example.cinematicket.ui.theme.Sans
import com.example.cinematicket.ui.theme.composable.IconButton
import com.example.cinematicket.ui.theme.composable.OutlineButton
import com.example.cinematicket.ui.theme.composable.SpacerHorizontal8
import com.example.cinematicket.ui.theme.composable.SpacerVertical16
import com.example.cinematicket.ui.theme.composable.SpacerVertical32
import kotlin.math.absoluteValue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
) {
    val state by remember { mutableStateOf(HomeUIState()) }
    val pagerState = rememberPagerState()
    HomeContent(state = state, pagerState = pagerState)
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: HomeUIState,
    pagerState: PagerState,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(45.dp),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(model = state.movies[pagerState.currentPage].imageUrl),
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White,
                        )
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Header()
            SpacerVertical32()
            MoviePager(modifier = Modifier.fillMaxWidth(), state = state, pagerState = pagerState)
            SpacerVertical16()
            MovieContent()

        }

    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlineButton(
            text = stringResource(R.string.now_showing),
            textColor = Color.White,
            buttonColor = Orange
        ) {}
        SpacerHorizontal8()
        OutlineButton(text = stringResource(R.string.coming_soon), textColor = Color.White) {}
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MoviePager(
    modifier: Modifier = Modifier,
    state: HomeUIState,
    pagerState: PagerState,
) {
    HorizontalPager(
        modifier = modifier,
        pageCount = state.movies.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
        pageSpacing = 16.dp
    ) { page ->
        val pageOffset = remember(pagerState) {
            val currentPage = pagerState.currentPage
            val currentPageOffset = pagerState.currentPageOffsetFraction
            (page - currentPage + currentPageOffset).absoluteValue
        }
        Card(
            modifier = Modifier
                .aspectRatio(0.8f)
                .graphicsLayer {
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                    scaleY = lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                },
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = state.movies[page].imageUrl),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun MovieContent() {

    IconButton(
        painter = R.drawable.clock,
        iconTint = Black80,
        text = stringResource(R.string.hour),
        textColor= Black80
    ) {}

    SpacerVertical16()

    Text(
        text = stringResource(R.string.title),
        fontSize = 22.sp,
        textAlign = TextAlign.Center,
        color = Black80,
        fontFamily = Sans,
        fontWeight = FontWeight.Medium

    )

    SpacerVertical16()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlineButton(text = stringResource(R.string.fantasy)) {}
        SpacerHorizontal8()
        OutlineButton(text = stringResource(R.string.adventure)) {}
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}