package com.samuelsumbane.ludoaura.presentation.uistate

data class PlayGameUiState(
    val firstButton: ButtonData = ButtonData(0, 0),
    val secondButton: ButtonData = ButtonData(0, 0)
)


data class ButtonData(
    val xPosition: Int,
    val yPosition: Int,

)

enum class PeaoButton { firstButton, secondButton}