package com.samuelsumbane.ludoaura

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samuelsumbane.ludoaura.presentation.viewmodel.PlayGameViewModel
import ludoaura.composeapp.generated.resources.Res
import ludoaura.composeapp.generated.resources.arrow_right_short
import ludoaura.composeapp.generated.resources.star
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

//import ludoaura.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val playGameViewModel: PlayGameViewModel = viewModel()
        val playGameUiState by playGameViewModel.playGame.collectAsState()
        val coroutine = rememberCoroutineScope()
        var boxHeight by remember { mutableStateOf(1.dp) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .onGloballyPositioned { coords ->
                        boxHeight = coords.size.width.dp
                    }
                    .height(boxHeight)
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
//            }


            }
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
    Text("s")

//    IconButton(
//        onClick = onClick,
//        modifier = Modifier.offset(xOffSet,yOffSet)
//    ) {
////        Icon(Icons.Default.)
//        Text("I")
//    }
}

@Composable
fun PeaoPlace() {
    val fItemWidth = 0.41f
    val sItemWidth = 0.59f
        Column(
            modifier = Modifier
                .fillMaxSize()
//                .fillMaxWidth(0.9f)
                .padding(10.dp)
                .background(Color.LightGray)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                RetangulusGroup(
                    identifierColor = Color.Green,
                    modifier = Modifier
                        .fillMaxWidth(fItemWidth)
                        .fillMaxHeight(sItemWidth)
                        .align(Alignment.TopStart),
                    childModifier = Modifier.align(Alignment.BottomCenter)
                )

                RetangulusGroup(
                    identifierColor = Color.Yellow,
                    rotationDegrees = 180f,
                    modifier = Modifier
//                        .weight(1f)
                        .fillMaxWidth(sItemWidth)
                        .fillMaxHeight(fItemWidth)
                        .align(Alignment.TopEnd),
                    childModifier = Modifier
                        .fillMaxWidth(0.80f),
                    inRow = true
                )

                RetangulusGroup(
                    identifierColor = Color.Red,
//                    rotationDegrees = -90f,
                    modifier = Modifier
                        .fillMaxWidth(sItemWidth)
                        .fillMaxHeight(fItemWidth)
                        .align(Alignment.BottomStart),
                    childModifier = Modifier
                        .fillMaxWidth(0.67f)
//                        .align(Alignment.BottomEnd)
                    ,
                    inRow = true
                )

                RetangulusGroup(
                    identifierColor = Color.Blue,
                    rotationDegrees = 180f,
                    modifier = Modifier
                        .fillMaxWidth(fItemWidth)
                        .fillMaxHeight(sItemWidth)
                        .align(Alignment.BottomEnd),
                    childModifier = Modifier

                )
            }





        }

}

@Composable
fun RetangulusGroup(
    identifierColor: Color,
    modifier: Modifier = Modifier,
    rotationDegrees: Float = 0f,
    childModifier: Modifier = Modifier,
    inRow: Boolean = false,
) {
    var retanguloHeight by remember { mutableStateOf(1.dp) }
    var retanguloWidth by remember { mutableStateOf(1.dp) }
    var dividerThick = 1.2.dp

    @Composable
    fun ItsContent(
        boxRotationDegrees: Float = 0f,
        boxModifier: Modifier = Modifier,
        childModifier: Modifier = Modifier,
        peaoGroupModifier: Modifier = Modifier
    ) {
        Column(
            modifier = peaoGroupModifier
                .background(Color.Black.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                .size(80.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PeaoRow {
                Peao {  }
                Peao {  }
            }
            PeaoRow {
                Peao {  }
                Peao {  }
            }
        }

        Box(
            modifier = boxModifier
                .background(Color.Cyan)
                .rotate(boxRotationDegrees)
        ) {
            @Composable
            fun StreetForHorizontal() {
                Box(
//                modifier = Modifier
                    modifier = childModifier
                        .background(MaterialTheme.colorScheme.background)
//                    .size(180.dp, 60.dp)
                        .fillMaxWidth()

//                    .height(62.dp)
//                    .align(Alignment.End)
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
                            .fillMaxHeight(1 / 3f)
                            .background(identifierColor)
//                .align(Alignment.Center)
                            .align(Alignment.CenterEnd)
                    ) {
                    }

                    // Arrow
                    Row(
                        modifier = Modifier
                            .padding(start = 3.dp, top = retanguloHeight + 5.dp)
                            .size(retanguloWidth, retanguloHeight)
//                .background(Color.Green)
                    ) {
                        Icon(
                            painterResource(Res.drawable.arrow_right_short),
                            contentDescription = "star",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(start = retanguloWidth + 6.dp, top = 2.dp)
                            .size(retanguloWidth, retanguloHeight)
                            .background(identifierColor),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painterResource(Res.drawable.star),
                            contentDescription = "star",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(7) {
                            VerticalDivider(
                                modifier = Modifier.zIndex(98f),
                                thickness = dividerThick, color = Color.Black
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(99f),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(4) { HorizontalDivider(thickness = dividerThick, color = Color.Black) }
                    }
                }
            }

            @Composable
            fun StreetForVertical() {
                Box(
//                modifier = Modifier
                    modifier = childModifier
                        .background(MaterialTheme.colorScheme.background)
//                    .size(180.dp, 60.dp)
                        .fillMaxHeight()
//                    .height(62.dp)
//                    .align(Alignment.End)
                        .onGloballyPositioned { coords ->
                            //
                            retanguloHeight = (coords.size.height.dp / 6) + 5.dp
                            retanguloWidth = (coords.size.width.dp / 3) - 5.dp
                        },
                ) {
                    Row(
                        modifier = Modifier
//                .size(80.dp, 40.dp)
                            .padding(start = 2.dp, end = 2.dp)
                            .fillMaxHeight(0.83f)
                            .fillMaxWidth(1 / 3f)
                            .background(identifierColor)
//                .align(Alignment.Center)
                            .align(Alignment.TopCenter)
                    ) {
                    }

//                     Arrow
                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp, top = retanguloHeight + 5.dp)
                            .size(retanguloWidth, retanguloHeight)
                            .align(Alignment.BottomCenter)
//                .background(Color.Green)
                    ) {
                        Icon(
                            painterResource(Res.drawable.arrow_right_short),
                            contentDescription = "arrow",
                            modifier = Modifier
                                .rotate(-90f)
                                .align(Alignment.CenterVertically)
                        )
                    }

                    Row(
                        modifier = Modifier
//                            .padding(bottom = retanguloHeight)
                            .size(retanguloHeight, retanguloWidth)
                            .align(Alignment.BottomStart)
                            .background(identifierColor),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painterResource(Res.drawable.star),
                            contentDescription = "star",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                        ,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                        horizontalAlignment = Alignm
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(7) {
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .zIndex(98f),
                                thickness = dividerThick, color = Color.Black
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(99f),
//                        verticalArrangement = Arrangement.SpaceBetween
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(4) { VerticalDivider(thickness = dividerThick, color = Color.Black) }
                    }
                }
            }
            if (inRow) StreetForVertical() else StreetForHorizontal()
        }
    }

    if (inRow) {
        Row(
            modifier = modifier
                .background(identifierColor)
                .rotate(rotationDegrees),
//            verticalArrangement = Arrangement.SpaceBetween
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ItsContent(
                boxModifier = Modifier
                    .width(60.dp),
                peaoGroupModifier = Modifier
                    .padding(start = 25.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    } else {
        Column(
            modifier = modifier
                .background(identifierColor)
                .rotate(rotationDegrees),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ItsContent(
                boxModifier = Modifier
                    .height(55.dp),
                peaoGroupModifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }

}


@Composable
fun PeaoRow(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(0.8f)
        ,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        content()
    }
}