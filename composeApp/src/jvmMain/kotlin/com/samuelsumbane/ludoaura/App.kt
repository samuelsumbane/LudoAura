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
import com.samuelsumbane.ludoaura.presentation.uistate.ButtonData
import com.samuelsumbane.ludoaura.presentation.uistate.PlayGameUiState
import com.samuelsumbane.ludoaura.presentation.viewmodel.PlayGameViewModel
import com.samuelsumbane.ludoaura.utils.ButtonIdentifier
import ludoaura.composeapp.generated.resources.Res
import ludoaura.composeapp.generated.resources.forward_fill
import ludoaura.composeapp.generated.resources.pawn
import ludoaura.composeapp.generated.resources.star_fill
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
//                .background(Color.DarkGray),
            ,
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

                val fItemWidth = 0.42f
                val sItemWidth = 0.58f
                Column(
                    modifier = Modifier
                        .fillMaxSize()
//                .fillMaxWidth(0.9f)
                        .padding(10.dp)
//                .background(Color.LightGray)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        with(playGameViewModel) {
                            RetangulusGroup(
                                pawnButton = listOf(
                                    ButtonIdentifier.GFirst,
                                    ButtonIdentifier.GSecond,
                                    ButtonIdentifier.GThird,
                                    ButtonIdentifier.GFourth,
                                ),
                                pawnButtonsData = listOf(
                                    playGameUiState.gFirst,
                                    playGameUiState.gSecond,
                                    playGameUiState.gThird,
                                    playGameUiState.gFourth,
                                ),
                                identifierColor = Color.Green,
                                modifier = Modifier
                                    .fillMaxWidth(fItemWidth)
                                    .fillMaxHeight(sItemWidth)
                                    .align(Alignment.TopStart),
                                border = Border.TopStart
                            )

                            RetangulusGroup(
                                pawnButton = listOf(
                                    ButtonIdentifier.YFirst,
                                    ButtonIdentifier.YSecond,
                                    ButtonIdentifier.YThird,
                                    ButtonIdentifier.YFourth,
                                ),
                                pawnButtonsData = listOf(
                                    playGameUiState.yFirst,
                                    playGameUiState.ySecond,
                                    playGameUiState.yThird,
                                    playGameUiState.yFourth,
                                ),
                                identifierColor = Color.Yellow,
                                rotationDegrees = 180f,
                                modifier = Modifier
                                    .fillMaxWidth(sItemWidth)
                                    .fillMaxHeight(fItemWidth)
                                    .align(Alignment.TopEnd),
                                border = Border.TopEnd,
                                inRow = true
                            )

                            RetangulusGroup(
                                pawnButton = listOf(
                                    ButtonIdentifier.RFirst,
                                    ButtonIdentifier.RSecond,
                                    ButtonIdentifier.RThird,
                                    ButtonIdentifier.RFourth,
                                ),
                                pawnButtonsData = listOf(
                                    playGameUiState.rFirst,
                                    playGameUiState.rSecond,
                                    playGameUiState.rThird,
                                    playGameUiState.rFourth,
                                ),
                                identifierColor = Color.Red,
                                modifier = Modifier
                                    .fillMaxWidth(sItemWidth)
                                    .fillMaxHeight(fItemWidth)
                                    .align(Alignment.BottomStart),
                                border = Border.BottomEnd,
                                inRow = true
                            )

                            RetangulusGroup(
                                pawnButton = listOf(
                                    ButtonIdentifier.BFirst,
                                    ButtonIdentifier.BSecond,
                                    ButtonIdentifier.BThird,
                                    ButtonIdentifier.BFourth,
                                ),
                                pawnButtonsData = listOf(
                                    playGameUiState.bFirst,
                                    playGameUiState.bSecond,
                                    playGameUiState.bThird,
                                    playGameUiState.bFourth,
                                ),
                                identifierColor = Color.Blue,
                                rotationDegrees = 180f,
                                modifier = Modifier
                                    .fillMaxWidth(fItemWidth)
                                    .fillMaxHeight(sItemWidth)
                                    .align(Alignment.BottomEnd),
                                border = Border.BottomStart
                            )
                        }

//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth(1f - fItemWidth * 2f)
//                                .fillMaxHeight(1f - fItemWidth * 2f)
//                                .background(Color.Magenta)
//                                .align(Alignment.Center)
//                        ) {
//                        }
                    }
                }


            }
        }
    }
}


@Composable
fun Peao(
    xOffSet: Dp = 0.dp,
    yOffSet: Dp = 0.dp,
    tint: Color,
    rotate: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .offset(xOffSet,yOffSet)
            .size(24.dp),
    ) {
        Icon(
            painter = painterResource(Res.drawable.pawn),
            contentDescription = "Pawn",
            tint = tint,
            modifier = if (rotate) Modifier.rotate(180f) else Modifier
       )
    }
}



context(playGameViewModel: PlayGameViewModel)
@Composable
fun RetangulusGroup(
//    playGameViewModel: PlayGameViewModel,
    pawnButton: List<ButtonIdentifier>,
    pawnButtonsData: List<ButtonData>,
    identifierColor: Color,
    modifier: Modifier = Modifier,
    rotationDegrees: Float = 0f,
//    childModifier: Modifier = Modifier,
    border: Border,
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
                .background(MaterialTheme.colorScheme.background, RoundedCornerShape(12.dp))
                .size(80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val pawnsColor = identifierColor
            val rotateIcon = rotationDegrees != 0f

            PeaoRow {
                Peao(
                    xOffSet = pawnButtonsData[0].xPosition.dp,
                    yOffSet = pawnButtonsData[0].yPosition.dp,
                    tint = pawnsColor,
                    rotate = rotateIcon
                ) { playGameViewModel.submit(pawnButton[0]) }

                Peao(
                    xOffSet = pawnButtonsData[1].xPosition.dp,
                    yOffSet = pawnButtonsData[1].yPosition.dp,
                    tint = pawnsColor,
                    rotate = rotateIcon
                ) { playGameViewModel.submit(pawnButton[1]) }
            }
            PeaoRow {
                Peao(
                    xOffSet = pawnButtonsData[2].xPosition.dp,
                    yOffSet = pawnButtonsData[2].yPosition.dp,
                    tint = pawnsColor,
                    rotate = rotateIcon
                ) { playGameViewModel.submit(pawnButton[2]) }

                Peao(
                    xOffSet = pawnButtonsData[3].xPosition.dp,
                    yOffSet = pawnButtonsData[3].yPosition.dp,
                    tint = pawnsColor,
                    rotate = rotateIcon
                ) { playGameViewModel.submit(pawnButton[3]) }
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
                            retanguloHeight = (coords.size.height.dp / 3) - 2.4.dp
                            retanguloWidth = (coords.size.width.dp / 6) - 2.4.dp
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
                            .padding(start = dividerThick, top = retanguloHeight + 5.dp)
                            .size(retanguloWidth, retanguloHeight)
//                .background(Color.Green)
                    ) {
                        ArrowIcon(tint = identifierColor, modifier = Modifier.align(Alignment.CenterVertically))
                    }

                    Row(
                        modifier = Modifier
                            .padding(start = dividerThick + 1.dp, top = dividerThick + 1.dp)
                            .size(retanguloWidth, retanguloHeight)
                            .background(identifierColor),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        StarIcon(modifier = Modifier.align(Alignment.CenterVertically))
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
                            retanguloHeight = (coords.size.height.dp / 6)
                            retanguloWidth = (coords.size.width.dp / 3)
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
                        ArrowIcon(
                            tint = identifierColor,
                            modifier = Modifier
                            .rotate(-90f)
                            .align(Alignment.CenterVertically)
                        )
                    }

                    Row(
                        modifier = Modifier
//                            .padding(bottom = retanguloHeight)
                            .size(retanguloWidth, retanguloHeight)
                            .align(Alignment.BottomStart)
                            .background(identifierColor),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        StarIcon(modifier = Modifier.align(Alignment.CenterVertically))
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

    val m = modifier
        .background(identifierColor, RoundedCornerShape(border.topStart, border.topEnd, border.bottomStart, border.bottomEnd))
        .rotate(rotationDegrees)

    if (inRow) {
        Row(
            modifier = m,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ItsContent(
                boxModifier = Modifier
                    .width(56.dp),
                peaoGroupModifier = Modifier
                    .padding(start = 25.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    } else {
        Column(
            modifier = m,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ItsContent(
                boxModifier = Modifier
                    .height(56.dp),
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

@Composable
fun StarIcon(modifier: Modifier, tint: Color = Color.White) {
    Icon(
        painterResource(Res.drawable.star_fill),
        contentDescription = "star",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ArrowIcon(modifier: Modifier, tint: Color = Color.White) {
    Icon(
        painterResource(Res.drawable.forward_fill),
        contentDescription = "arrow",
        modifier = modifier,
        tint = tint
    )
}

enum class Border(
    val topStart: Dp,
    val topEnd: Dp,
    val bottomStart: Dp,
    val bottomEnd: Dp
) {
    TopStart(40.dp, 0.dp, 0.dp, 0.dp),
    TopEnd(0.dp, 40.dp, 0.dp, 0.dp),
    BottomStart(0.dp, 0.dp, 40.dp, 0.dp),
    BottomEnd(0.dp, 0.dp, 0.dp, 40.dp)
}