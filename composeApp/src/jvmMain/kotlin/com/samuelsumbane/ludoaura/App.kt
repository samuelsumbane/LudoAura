package com.samuelsumbane.ludoaura

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
        val playGameViewModel: PlayGameViewModel = viewModel()
        val playGameUiState by playGameViewModel.playGame.collectAsState()
        val coroutine = rememberCoroutineScope()

        Column(
            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
                PeaoPlace()
//            Column(
//                modifier = Modifier
////                    .size(50.dp)
//                    .background(Color.Green)
//            ) {


//                SpaceAroundRow {
//                    Peao(){
//
//                    }
//                    Peao(
//                        playGameUiState.firstButton.xPosition.dp,
//                        playGameUiState.firstButton.yPosition.dp,
//                    ) {
//                        coroutine.launch {
//                            repeat(29) {
//                                delay(560)
//                                playGameViewModel.submit(PeaoButton.firstButton)
//                                println("runned $it")
//                            }
//                        }
//                    }
//                }

//                SpaceAroundRow {
//                    Peao({})
//                    Peao({})
//                }

//            }

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

@Preview
@Composable
fun PeaoPlace() {
    Column() {
        Column() {

        }
        Column {
            RetangulusGroup()
        }
    }
}

@Composable
fun RetangulusGroup() {
    var retanguloHeight by remember { mutableStateOf(1.dp) }
    var retanguloWidth by remember { mutableStateOf(1.dp) }

    Box(
        modifier = Modifier
            .background(Color.Red)
            .size(180.dp, 60.dp)
            .onGloballyPositioned { coords ->
                //
                retanguloHeight = (coords.size.height.dp / 3) - 4.dp
                retanguloWidth = (coords.size.width.dp / 6) - 4.dp
            },
    ) {


        Row(
            modifier = Modifier
//                .size(80.dp, 40.dp)
                .padding(start = 2.dp, end = 2.dp)
                .fillMaxWidth(0.83f)
                .fillMaxHeight(1/3f)
                .background(Color.LightGray)
//                .align(Alignment.Center)
                .align(Alignment.CenterEnd)
        ) {

        }

        Row(
            modifier = Modifier
                .padding(start = retanguloWidth + 6.dp, top = 2.dp)
                .size(retanguloWidth, retanguloHeight)
                .background(Color.Magenta)
        ) {
//            Icon(painterR, contentDescription = "star")
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(7) {
                VerticalDivider(
                    modifier = Modifier.zIndex(98f),
                    thickness = 2.dp, color = Color.Black) }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(99f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(4) { HorizontalDivider(thickness = 2.dp, color = Color.Black) }
        }


    }
}