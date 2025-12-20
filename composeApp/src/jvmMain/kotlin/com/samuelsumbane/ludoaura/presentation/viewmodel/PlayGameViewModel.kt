package com.samuelsumbane.ludoaura.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.samuelsumbane.ludoaura.presentation.uistate.PlayGameUiState
import com.samuelsumbane.ludoaura.utils.ButtonIdentifier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlayGameViewModel : ViewModel() {

    val _playGame = MutableStateFlow(PlayGameUiState())
    val playGame = _playGame.asStateFlow()

    private val jupper = 30

    fun submit(button: ButtonIdentifier) {
//        val buttonData = if (button == ButtonIdentifier.GFirst) playGame.value.firstButton else playGame.value.secondButton

        val buttonData = when(button) {
            ButtonIdentifier.GFirst -> playGame.value
        }

        fun moveFButtonToLeft() = changeFButtonPosition(buttonData.xPosition - jupper, buttonData.yPosition)
        fun moveFButtonToRight() = changeFButtonPosition(buttonData.xPosition + jupper, buttonData.yPosition)
        fun moveFButtonDown() = changeFButtonPosition(buttonData.xPosition, buttonData.yPosition + jupper)
        fun moveFButtonUp() = changeFButtonPosition(buttonData.xPosition, buttonData.yPosition - jupper)

        when {
            buttonData.xPosition == 0 && buttonData.yPosition == 0 -> {
                changeFButtonPosition(jupper, 0)
                println("moved to right")
            }
            buttonData.yPosition < jupper * 4 -> {
                moveFButtonDown()
                println("moved to down ${buttonData.yPosition} < ${(jupper * 5)}")

            }
            buttonData.yPosition == (jupper * 4) && buttonData.xPosition < jupper * 4 -> {
                moveFButtonToRight()
                println("moved to right ${buttonData.yPosition} == ${(jupper * 4)}")
            }

            buttonData.xPosition == jupper * 4 && buttonData.yPosition < jupper * 6 -> {
                moveFButtonDown()
                println("moved to down ${buttonData.xPosition} == ${(jupper * 4)}")
            }
            buttonData.yPosition == jupper * 6 && buttonData.xPosition > jupper -> {
                moveFButtonToLeft()
                println("moving to left")
            }
            (buttonData.yPosition == jupper * 6 && buttonData.xPosition == jupper) || buttonData.yPosition < jupper * 9 && buttonData.xPosition == jupper -> {
                println("moved down again ${buttonData.xPosition} == ${(jupper)}")
                moveFButtonDown()
            }
            buttonData.yPosition == jupper * 9 && buttonData.xPosition > jupper * -1 -> {
                println("xposition is: ${buttonData.xPosition}")
                println("move left (3) times ${buttonData.xPosition} < ${(jupper)}")
                moveFButtonToLeft()
            }

            buttonData.xPosition == jupper * -1 && buttonData.yPosition > jupper * 6 -> {
                moveFButtonUp()
            }
            (buttonData.xPosition == jupper * -1 && buttonData.yPosition == jupper * 6) || (buttonData.yPosition == jupper * 6 && buttonData.xPosition > jupper * -3) -> {
                moveFButtonToLeft()
            }
            buttonData.yPosition >= jupper * 3 -> {
                moveFButtonUp()
                println("x position is: ${buttonData.xPosition}")
            }
            buttonData.yPosition == jupper * 3 && buttonData.xPosition < jupper -> {
                moveFButtonToLeft()
            }

        }
    }



    fun changeFButtonPosition(aditionalXPosition: Int, aditionalYPosition: Int) {
        _playGame.update {
            it.copy(firstButton = it.firstButton.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
        }
    }

    fun changeSecondButtonPosition(aditionalXPosition: Int, aditionalYPosition: Int) {
        _playGame.update {
            it.copy(secondButton = it.secondButton.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
        }
    }

}