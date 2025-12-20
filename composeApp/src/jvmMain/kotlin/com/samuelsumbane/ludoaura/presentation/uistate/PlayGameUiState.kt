package com.samuelsumbane.ludoaura.presentation.uistate

val defaultButtonData = ButtonData(0, 0)

data class PlayGameUiState(
    val gFirst: ButtonData = defaultButtonData,
    val gSecond: ButtonData = defaultButtonData,
    val gThird: ButtonData = defaultButtonData,
    val gFourth: ButtonData = defaultButtonData,
    val yFirst: ButtonData = defaultButtonData,
    val ySecond: ButtonData = defaultButtonData,
    val yThird: ButtonData = defaultButtonData,
    val yFourth: ButtonData = defaultButtonData,
    val rFirst: ButtonData = defaultButtonData,
    val rSecond: ButtonData = defaultButtonData,
    val rThird: ButtonData = defaultButtonData,
    val rFourth: ButtonData = defaultButtonData,
    val bFirst: ButtonData = defaultButtonData,
    val bSecond: ButtonData = defaultButtonData,
    val bThird: ButtonData = defaultButtonData,
    val bFourth: ButtonData = defaultButtonData
)


data class ButtonData(val xPosition: Int, val yPosition: Int)
