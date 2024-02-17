package com.lamda.tictactoe.ui.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import com.lamda.tictactoe.ui.game.CardType
import com.lamda.tictactoe.ui.theme.Blue40
import com.lamda.tictactoe.ui.theme.Blue60
import com.lamda.tictactoe.ui.theme.Orange30
import com.lamda.tictactoe.ui.theme.Orange60

@Preview
@Composable
fun MicroXOPreview() {
    MicroXO(
        CardType.XCard
    )
}


@Composable
fun MicroXO(
    type: CardType,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth(1f / 36)
            .aspectRatio(1f)
    ) {
        val xWidth = size.width * (23 / 25f);
        val xHeight = size.height * (1 / 5f);
        if (type == CardType.XCard) {
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
        } else if (type == CardType.OCard) {
            val gradient = Brush.horizontalGradient(listOf(Blue60, Blue40))
            drawCircle(
                brush = gradient,
                radius = (xWidth / 3),
                style = Stroke(xHeight)
            )
        }
    }
}