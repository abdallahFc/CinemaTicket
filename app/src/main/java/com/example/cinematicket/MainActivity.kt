package com.example.cinematicket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cinematicket.screens.DetailsScreen
import com.example.cinematicket.screens.HomeScreen
import com.example.cinematicket.screens.TicketScreen
import com.example.cinematicket.ui.theme.CinemaTicketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaTicketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    HomeScreen()
                    //TicketScreen()
                    //DetailsScreen()
                }
            }
        }
    }
}
