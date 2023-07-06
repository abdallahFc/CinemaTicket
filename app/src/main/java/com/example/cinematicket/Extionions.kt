package com.example.cinematicket

import com.example.cinematicket.states.ChairState

fun ChairState.updateState(): ChairState {
    return when(this){
        ChairState.Available -> ChairState.Taken
        ChairState.Taken -> ChairState.Selected
        ChairState.Selected -> ChairState.Available
    }
}