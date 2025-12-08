package com.samuelsumbane.ludoaura

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samuelsumbane.ludoaura.presentation.uistate.PeaoButton
import com.samuelsumbane.ludoaura.presentation.viewmodel.PlayGameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import ludoaura.composeapp.generated.resources.Res
//import ludoaura.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var fXOffSetButton by remember { mutableStateOf(0.dp)}
        var fYOffSetButton by remember { mutableStateOf(0.dp)}
        val playGameViewModel: PlayGameViewModel = viewModel()
        val playGameUiState by playGameViewModel.playGame.collectAsState()
        val coroutine = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
//                    .size(50.dp)
                    .background(Color.Green)
            ) {
                SpaceAroundRow {
                    Peao(){

                    }
                    Peao(
                        playGameUiState.firstButton.xPosition.dp,
                        playGameUiState.firstButton.yPosition.dp,
                    ) {
                            coroutine.launch {
                                repeat(12) {
                                    delay(560)
                                    playGameViewModel.submit(PeaoButton.firstButton)

                                }

                            }
                    }
                }

//                SpaceAroundRow {
//                    Peao({})
//                    Peao({})
//                }

            }

//            Column() {
//                Text()
//            }
        }
    }
}

@Composable
fun SpaceAroundRow(content: @Composable () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        content()
    }
}

@Composable
fun Peao(
    xOffSet: Dp = 0.dp,
    yOffSet: Dp = 0.dp,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.offset(xOffSet,yOffSet)
    ) {
//        Icon(Icons.Default.)
        Text("I")
    }
}


fun runPeao(

) {

}