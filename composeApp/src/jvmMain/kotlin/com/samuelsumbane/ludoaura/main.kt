package com.samuelsumbane.ludoaura

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "LudoAura",
        state = WindowState(
            size = DpSize(400.dp, 570.dp)
        ),
        alwaysOnTop = true,
        resizable = false
    ) {
        App()
    }
}