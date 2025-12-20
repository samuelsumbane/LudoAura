package com.samuelsumbane.ludoaura.presentation.viewmodel

import androidx.compose.ui.unit.dp
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
        val buttonData = when(button) {
            ButtonIdentifier.GFirst -> playGame.value.gFirst
            ButtonIdentifier.GSecond -> playGame.value.gSecond
            ButtonIdentifier.GThird -> playGame.value.gThird
            ButtonIdentifier.GFourth -> playGame.value.gFourth
            ButtonIdentifier.YFirst -> playGame.value.yFirst
            ButtonIdentifier.YSecond -> playGame.value.ySecond
            ButtonIdentifier.YThird -> playGame.value.yThird
            ButtonIdentifier.YFourth -> playGame.value.yFourth
            ButtonIdentifier.RFirst -> playGame.value.rFirst
            ButtonIdentifier.RSecond -> playGame.value.rSecond
            ButtonIdentifier.RThird -> playGame.value.rThird
            ButtonIdentifier.RFourth -> playGame.value.rFourth
            ButtonIdentifier.BFirst -> playGame.value.bFirst
            ButtonIdentifier.BSecond -> playGame.value.bSecond
            ButtonIdentifier.BThird -> playGame.value.bThird
            ButtonIdentifier.BFourth -> playGame.value.bFourth
        }

        fun moveButtonToLeft() = changeFButtonPosition(button, buttonData.xPosition - jupper, buttonData.yPosition)
        fun moveButtonToRight() = changeFButtonPosition(button, buttonData.xPosition + jupper, buttonData.yPosition)
        fun moveButtonDown() = changeFButtonPosition(button, buttonData.xPosition, buttonData.yPosition + jupper)
        fun moveButtonUp() = changeFButtonPosition(button, buttonData.xPosition, buttonData.yPosition - jupper)

        when {
            buttonData.xPosition == 0 && buttonData.yPosition == 0 -> {
                moveButtonToRight()
                println("moved to right")
            }
            buttonData.yPosition < jupper * 4 -> {
                moveButtonDown()
                println("moved to down ${buttonData.yPosition} < ${(jupper * 5)}")

            }
            buttonData.yPosition == (jupper * 4) && buttonData.xPosition < jupper * 4 -> {
                moveButtonToRight()
                println("moved to right ${buttonData.yPosition} == ${(jupper * 4)}")
            }

            buttonData.xPosition == jupper * 4 && buttonData.yPosition < jupper * 6 -> {
                moveButtonDown()
                println("moved to down ${buttonData.xPosition} == ${(jupper * 4)}")
            }
            buttonData.yPosition == jupper * 6 && buttonData.xPosition > jupper -> {
                moveButtonToLeft()
                println("moving to left")
            }
            (buttonData.yPosition == jupper * 6 && buttonData.xPosition == jupper) || buttonData.yPosition < jupper * 9 && buttonData.xPosition == jupper -> {
                println("moved down again ${buttonData.xPosition} == ${(jupper)}")
                moveButtonDown()
            }
            buttonData.yPosition == jupper * 9 && buttonData.xPosition > jupper * -1 -> {
                println("xposition is: ${buttonData.xPosition}")
                println("move left (3) times ${buttonData.xPosition} < ${(jupper)}")
                moveButtonToLeft()
            }

            buttonData.xPosition == jupper * -1 && buttonData.yPosition > jupper * 6 -> {
                moveButtonUp()
            }
            (buttonData.xPosition == jupper * -1 && buttonData.yPosition == jupper * 6) || (buttonData.yPosition == jupper * 6 && buttonData.xPosition > jupper * -3) -> {
                moveButtonToLeft()
            }
            buttonData.yPosition >= jupper * 3 -> {
                moveButtonUp()
                println("x position is: ${buttonData.xPosition}")
            }
            buttonData.yPosition == jupper * 3 && buttonData.xPosition < jupper -> {
                moveButtonToLeft()
            }

        }
    }


    fun changeFButtonPosition(button: ButtonIdentifier, aditionalXPosition: Int, aditionalYPosition: Int) {
        _playGame.update {
            when (button) {
                ButtonIdentifier.GFirst -> it.copy(gFirst = it.gFirst.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.GSecond -> it.copy(gSecond = it.gSecond.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.GThird -> it.copy(gThird = it.gThird.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.GFourth -> it.copy(gFourth = it.gFourth.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.YFirst -> it.copy(yFirst = it.yFirst.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.YSecond -> it.copy(ySecond = it.ySecond.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.YThird -> it.copy(yThird = it.yThird.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.YFourth -> it.copy(yFourth = it.yFourth.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.RFirst -> it.copy(rFirst = it.rFirst.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.RSecond -> it.copy(rSecond = it.rSecond.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.RThird -> it.copy(rThird = it.rThird.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.RFourth -> it.copy(rFourth = it.rFourth.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.BFirst -> it.copy(bFirst = it.bFirst.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.BSecond -> it.copy(bSecond = it.bSecond.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.BThird -> it.copy(bThird = it.bThird.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
                ButtonIdentifier.BFourth -> it.copy(bFourth = it.bFourth.copy(xPosition = aditionalXPosition, yPosition = aditionalYPosition))
            }
        }
    }
}