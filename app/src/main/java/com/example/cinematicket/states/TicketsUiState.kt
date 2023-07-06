package com.example.cinematicket.states

data class TicketsUiState(
    val days: List<Day> = listOf(
        Day(14, "Thu"),
        Day(15, "Fri"),
        Day(16, "Sat"),
        Day(17, "Sun"),
        Day(18, "Mon"),
        Day(19, "Tue"),
        Day(20, "Wed"),
        Day(21, "Thu"),
        Day(22, "Fri"),
    ),
    val timeList: List<String> = listOf(
        "10:00",
        "12:30",
        "15:30",
        "18:00",
        "18:30",
        "21:30",
        "23:00",
    ),
    val selectedDay: Day = Day(17, "Sun"),
    val selectedTime: String = "12:30",
)

data class Day(val dayNumber: Int, val dayName: String)