package com.lamda.tictactoe.ui.game.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lamda.tictactoe.portrait
import com.lamda.tictactoe.ui.AppScreens
import com.lamda.tictactoe.ui.game.CardType
import com.lamda.tictactoe.ui.game.components.GameLogo
import com.lamda.tictactoe.ui.game.components.MicroXO
import com.lamda.tictactoe.ui.theme.Blue10
import com.lamda.tictactoe.ui.theme.Blue40
import com.lamda.tictactoe.ui.theme.Blue70
import com.lamda.tictactoe.ui.theme.Orange30
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    hideSystemBar: ()-> Unit,
    mode:String
) {
    hideSystemBar()
    val logoFontSize = if(mode == portrait) 32 else 64
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue70)
            .padding(horizontal = 60.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2.6f),
            border = BorderStroke(
                4.dp, Brush.linearGradient(
                    listOf(Orange30, Blue40, Orange30),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                )
            ),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                Blue10
            ),
            elevation = CardDefaults.cardElevation(24.dp)
        ) {
            val x = CardType.XCard
            val o = CardType.OCard

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp)) {
                    repeat(15) {
                        MicroXO(type = x, Modifier.weight(1f))
                        MicroXO(type = o, Modifier.weight(1f))
                    }
                }
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GameLogo(
                        fontSize = logoFontSize
                    )
                }
            }
        }

        Canvas(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .height(14.dp)
                .blur(8.dp, BlurredEdgeTreatment(shape = null))
        ) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radiusX = size.width / 2
            val radiusY = size.height / 2


            drawOval(
                color = Blue10,
                topLeft = Offset(centerX - radiusX, centerY - radiusY),
                size = size
            )
        }

    }

    LaunchedEffect(true) {
        delay(2000)
        navController.navigate(AppScreens.MainMenu.name)
    }
}