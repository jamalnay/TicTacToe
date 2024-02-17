package com.lamda.tictactoe.ui.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.navigation.NavController
import com.lamda.tictactoe.ui.theme.Blue60
import com.lamda.tictactoe.ui.theme.Blue70


@Composable
fun CloseIcon(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Box(modifier = modifier
        .fillMaxWidth(1f / 12)
        .aspectRatio(1f)
        .clickable {
            navController.navigateUp()
        }
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val xWidth = size.width * (23 / 25f)
            val xHeight = size.height * (1 / 5f)
            val gradient = Brush.horizontalGradient(listOf(Blue70, Blue60, Blue70))
            rotate(45f) {
                drawRoundRect(
                    brush = gradient,
                    size = Size(xWidth, xHeight),
                    cornerRadius = CornerRadius(12f, 12f),
                    topLeft = Offset(
                        (size.width / 2) - (xWidth / 2),
                        (size.height / 2) - (xHeight / 2)
                    )
                )
            }
            rotate(135f) {
                drawRoundRect(
                    brush = gradient,
                    size = Size(xWidth, xHeight),
                    cornerRadius = CornerRadius(12f, 12f),
                    topLeft = Offset(
                        (size.width / 2) - (xWidth / 2),
                        (size.height / 2) - (xHeight / 2)
                    )
                )
            }
        }
    }
}