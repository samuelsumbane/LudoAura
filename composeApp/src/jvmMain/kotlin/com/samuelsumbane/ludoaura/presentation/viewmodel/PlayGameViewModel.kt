package com.samuelsumbane.ludoaura.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.samuelsumbane.ludoaura.presentation.uistate.PeaoButton
import com.samuelsumbane.ludoaura.presentation.uistate.PlayGameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlayGameViewModel : ViewModel() {

    val _playGame = MutableStateFlow(PlayGameUiState())
    val playGame = _playGame.asStateFlow()

    private val jupper = 30

    fun submit(button: PeaoButton) {
        val buttonData = if (button == PeaoButton.firstButton) playGame.value.firstButton else playGame.value.secondButton

        when {
            buttonData.xPosition == 0 -> {
                changeFButtonPosition(jupper, 0)
                println("moved to right")
            }
            buttonData.yPosition < (jupper * 4) -> {
                //
                changeFButtonPosition(buttonData.xPosition, buttonData.yPosition + jupper)
                println("moved to down ${buttonData.yPosition} < ${(jupper * 5)}")

            }
            buttonData.yPosition == (jupper * 4) && buttonData.xPosition < jupper * 4 -> {
                //
                changeFButtonPosition(buttonData.xPosition + jupper, buttonData.yPosition)
                println("moved to right ${buttonData.yPosition} == ${(jupper * 4)}")

            }
            buttonData.xPosition == jupper * 4 && buttonData.yPosition < jupper * 6 -> {
                changeFButtonPosition(buttonData.xPosition, buttonData.yPosition + jupper)
                println("moved to down ${buttonData.xPosition} == ${(jupper * 4)}")
            }
            buttonData.yPosition == jupper * 6 -> {
                changeFButtonPosition(buttonData.xPosition - jupper, buttonData.yPosition)

            }
        }
    }

    fun nextHouse() {

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