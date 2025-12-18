package com.samuelsumbane.ludoaura.presentation.uistate

val defaultButtonData = ButtonData(0, 0)

data class PlayGameUiState(
    val firstButton: ButtonData = defaultButtonData,
    val secondButton: ButtonData = defaultButtonData
)


data class ButtonData(val xPosition: Int, val yPosition: Int)
