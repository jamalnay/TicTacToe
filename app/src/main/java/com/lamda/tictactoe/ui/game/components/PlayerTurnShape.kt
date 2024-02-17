package com.lamda.tictactoe.ui.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.lamda.tictactoe.ui.game.CardType
import com.lamda.tictactoe.ui.theme.Blue40
import com.lamda.tictactoe.ui.theme.Blue60
import com.lamda.tictactoe.ui.theme.Orange30
import com.lamda.tictactoe.ui.theme.Orange60

@Composable
fun PlayerTurnShape(
    turn: CardType?,
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth(1f / 12)
            .aspectRatio(1f)
            .padding(3.dp)
    ) {
        val xWidth = size.width * (23 / 25f)
        val xHeight = size.height * (1 / 5f)
        when (turn) {
            CardType.XCard -> {
                val gradient = Brush.horizontalGradient(listOf(Orange60, Orange30))
                rotate(45f) {
                    drawRect(
                        brush = gradient,
                        size = Size(xWidth, xHeight),
                        // X = (size.width/2)-(xWidth/2)
                        // Y = (size.height/2)-(xHeight/2)
                        topLeft = Offset(
                            (size.width / 2) - (xWidth / 2),
                            (size.height / 2) - (xHeight / 2)
                        )
                    )
                }
                rotate(135f) {
                    drawRect(
                        brush = gradient,
                        size = Size(xWidth, xHeight),
                        // X = (size.width/2)-(xWidth/2)
                        // Y = (size.height/2)-(xHeight/2)
                        topLeft = Offset(
                            (size.width / 2) - (xWidth / 2),
                            (size.height / 2) - (xHeight / 2)
                        )
                    )
                }
            }
            CardType.OCard -> {
                val gradient = Brush.horizontalGradient(listOf(Blue60, Blue40))
                drawCircle(
                    brush = gradient,
                    radius = (xWidth / 2),
                    style = Stroke(xHeight)
                )
            }
            else -> {
                drawCircle(
                    color = Color.Transparent,
                    radius = (xWidth / 2),
                    style = Stroke(xHeight)
                )
            }
        }
    }
}