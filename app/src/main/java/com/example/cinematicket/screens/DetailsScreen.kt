package com.example.cinematicket.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematicket.R
import com.example.cinematicket.ui.theme.Black80
import com.example.cinematicket.ui.theme.Orange
import com.example.cinematicket.ui.theme.Sans
import com.example.cinematicket.ui.theme.composable.IconButton
import com.example.cinematicket.ui.theme.composable.MovieRateText
import com.example.cinematicket.ui.theme.composable.OutlineButton
import com.example.cinematicket.ui.theme.composable.SpacerHorizontal8
import com.example.cinematicket.ui.theme.composable.SpacerVertical16

@Composable
fun DetailsScreen() {
    ScreenContent()
}

@Composable
private fun ScreenContent() {

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxSize()
            ) {
                Header()
            }
            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Column {
            Column(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.weight(1f))
            }
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxSize()
            ) {
                BottomSheet()
            }
        }

    }
}


@Composable
private fun Header(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = "https://www.themoviedb.org/t/p/w220_and_h330_face/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(painter = R.drawable.close_circle) {}
            IconButton(painter = R.drawable.clock, text = stringResource(R.string.hour)) {}
        }

        IconButton(
            painter = R.drawable.play,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
            backgroundColor = Orange
        ) {}
    }
}

@Composable
private fun BottomSheet(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color.White)
    ) {
        Box(modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    MovieRateText(
                        title = stringResource(R.string.rate), subtitle = stringResource(
                            R.string.imdb
                        )
                    )
                    MovieRateText(
                        title = stringResource(R.string.precent), subtitle = stringResource(
                            R.string.rotten_tomatoes
                        )
                    )
                    MovieRateText(
                        title = stringResource(R.string.rate_value), subtitle = stringResource(
                            R.string.ign
                        )
                    )
                }

                SpacerVertical16()
                Text(
                    text = stringResource(R.string.movie),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = Sans,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlineButton(text = stringResource(R.string.fantasy)) {}
            SpacerHorizontal8()
            OutlineButton(text = stringResource(R.string.adventure)) {}
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(20) {
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    painter = rememberAsyncImagePainter(model = "https://www.themoviedb.org/t/p/w138_and_h175_face/rRdru6REr9i3WIHv2mntpcgxnoY.jpg")
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.description),
                fontSize = 14.sp,
                lineHeight = 15.sp,
                color = Black80,
                fontFamily = Sans,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                painter = R.drawable.card,
                backgroundColor = Orange,
                text = "Booking",
                textSize = 16
            ) {

            }
        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBookingScreen() {
    DetailsScreen()
}