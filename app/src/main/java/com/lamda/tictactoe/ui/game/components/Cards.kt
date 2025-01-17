package com.lamda.tictactoe.ui.game.components

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lamda.tictactoe.ui.game.CardType
import com.lamda.tictactoe.ui.theme.Blue40
import com.lamda.tictactoe.ui.theme.Blue80
import com.lamda.tictactoe.ui.theme.Blue60
import com.lamda.tictactoe.ui.theme.BlueShade100
import com.lamda.tictactoe.ui.theme.BlueShade80
import com.lamda.tictactoe.ui.theme.BlueShade90
import com.lamda.tictactoe.ui.theme.Orange30
import com.lamda.tictactoe.ui.theme.Orange40
import com.lamda.tictactoe.ui.theme.Orange60

@Preview
@Composable
fun XCard(
    modifier: Modifier = Modifier
) {

    val rotationY  = remember {
        Animatable(-90f)
    }
    LaunchedEffect(key1 = Unit) {
        rotationY.animateTo(
            targetValue = 0f,
            animationSpec = tween(250)
        )
    }
    Card(
        modifier = modifier
            .fillMaxWidth(1f / 3)
            .aspectRatio(1f)
            .border(BorderStroke(2.dp, Orange40))
            .padding(4.dp)
            .graphicsLayer {
                this.rotationY = rotationY.value
                this.cameraDistance = 12f * density
            }
            .drawBehind {
                drawRect(
                    color = BlueShade100,
                    size = size
                )
                val xWidth = size.width*(23 / 25f)
                val xHeight = size.height*(1 / 8f)
                val gradient = Brush.horizontalGradient(listOf(Orange60,Orange30))

                drawCircle(
                    color = BlueShade90,
                    radius = (xWidth/2)-48,
                    style = Stroke(xHeight)
                )
                rotate(45f){
                    drawRect(
                        brush = gradient,
                        size = Size(xWidth,xHeight),
                        // X = (size.width/2)-(xWidth/2)
                        // Y = (size.height/2)-(xHeight/2)
                        topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                    )
                }
                rotate(135f){
                    drawRect(
                        brush = gradient,
                        size = Size(xWidth,xHeight),
                        // X = (size.width/2)-(xWidth/2)
                        // Y = (size.height/2)-(xHeight/2)
                        topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                    )
                }
            },
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            Color.Transparent
        )
    ) {

    }
}

@Preview
@Composable
fun OCard(
    modifier: Modifier = Modifier
) {
    val rotationY  = remember {
        Animatable(-90f)
    }
    LaunchedEffect(key1 = Unit) {
        rotationY.animateTo(
            targetValue = 0f,
            animationSpec = tween(250)
        )
    }

    Card(
        modifier = modifier
            .fillMaxWidth(1f / 3)
            .aspectRatio(1f)
            .border(BorderStroke(2.dp, Blue80))
            .padding(4.dp)
            .graphicsLayer {
                this.rotationY = rotationY.value
                this.cameraDistance = 12f * density
            }
            .drawBehind {
                drawRect(
                    color = BlueShade100,
                    size = size
                )
                val xWidth = size.width*(23 / 25f)
                val xHeight = size.height*(1 / 8f)
                val gradient = Brush.horizontalGradient(listOf(Blue60, Blue40))


                rotate(45f){
                    drawRect(
                        color = BlueShade90,
                        size = Size(xWidth,xHeight),
                        topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                    )
                }
                rotate(135f){
                    drawRect(
                        color = BlueShade90,
                        size = Size(xWidth,xHeight),
                        topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                    )
                }
                drawCircle(
                    brush = gradient,
                    radius = (xWidth/2)-24,
                    style = Stroke(xHeight)
                )
            },
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            Color.Transparent
        )
    ) {
    }
}


@Composable
fun EmptyCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    indexRow: String = ""
) {
    Button(
        modifier = modifier
            .fillMaxWidth(1f / 3)
            .aspectRatio(1f)
            .border(BorderStroke(2.dp, BlueShade100))
            .padding(4.dp)
            .graphicsLayer {
                this.rotationY = rotationY
                this.cameraDistance = 12f * density
            }
            .drawBehind {
                drawRect(
                    color = BlueShade100,
                    size = size
                )
            },
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        onClick = {
            Log.d("row / index",indexRow)
            onClick()
        }
    ) {
        Canvas(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .fillMaxHeight()
        ){
            val xWidth = size.width*(23 / 8f)
            val xHeight = size.height*(1 / 5f)

            drawCircle(
                color = BlueShade80,
                radius = (xWidth/2)-24,
                style = Stroke(xHeight)
            )
            rotate(45f){
                drawRect(
                    color = BlueShade80,
                    size = Size(xWidth,xHeight),
                    topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                )
            }
            rotate(135f){
                drawRect(
                    color = BlueShade80,
                    size = Size(xWidth,xHeight),
                    topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                )
            }
        }
    }
}
@Composable
fun WinnerCard(
    modifier: Modifier = Modifier,
    winner: CardType?,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(1f / 3)
            .aspectRatio(1f)
            .border(BorderStroke(2.dp, Blue80))
            .padding(4.dp)
            .drawBehind {
                drawRect(
                    color = BlueShade100,
                    size = size
                )
            },
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            Color.Transparent
        )
    ) {
        Canvas(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .fillMaxHeight()
        ){
            val xWidth = size.width*(23 / 25f)
            val xHeight = size.height*(1 / 8f)

            when (winner) {
                CardType.OCard -> {
                    drawCircle(
                        color = Blue60,
                        radius = (xWidth/2)-24,
                        style = Stroke(xHeight)
                    )
                }
                CardType.XCard -> {
                    rotate(45f){
                        drawRect(
                            color = Blue60,
                            size = Size(xWidth,xHeight),
                            topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                        )
                    }
                    rotate(135f){
                        drawRect(
                            color = Blue60,
                            size = Size(xWidth,xHeight),
                            topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                        )
                    }
                }
                else -> {
                    drawCircle(
                        color = Blue60,
                        radius = (xWidth/2)-24,
                        style = Stroke(xHeight)
                    )
                    rotate(45f){
                        drawRect(
                            color = Blue60,
                            size = Size(xWidth,xHeight),
                            topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                        )
                    }
                    rotate(135f){
                        drawRect(
                            color = Blue60,
                            size = Size(xWidth,xHeight),
                            topLeft = Offset((size.width/2)-(xWidth/2),(size.height/2)-(xHeight/2))
                        )
                    }
                }
            }
        }
    }
}