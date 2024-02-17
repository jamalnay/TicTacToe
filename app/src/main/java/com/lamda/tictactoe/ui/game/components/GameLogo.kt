package com.lamda.tictactoe.ui.game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lamda.tictactoe.ui.theme.Blue40
import com.lamda.tictactoe.ui.theme.Blue60
import com.lamda.tictactoe.ui.theme.Orange30
import com.lamda.tictactoe.ui.theme.Orange60
import com.lamda.tictactoe.ui.theme.masterOutlinedFamily

@Composable
fun GameLogo(
    fontSize:Int,
    modifier:Modifier = Modifier
)
{
    val blueGradient = Brush.linearGradient(
        listOf(Blue60, Blue40),
        start = Offset(0f, 0f),
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )

    //we need some transparent white, i am defining color values using RGBA system
    val whiteGradient = Brush.linearGradient(
        listOf(
            Color(255,255,255,0xFF),
            Color(255,255,255,0xBF) ,
            Color(255,255,255,0xB3),
            Color(255,255,255,0xE6),
            Color(255,255,255,0xFF)),
        start = Offset(0f, 0f),
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )
    val orangeGradient = Brush.linearGradient(
        listOf(Orange60, Orange30),
        start = Offset(0f, 0f),
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            modifier = Modifier.padding(end = (fontSize/6).dp),
            text = "Tic",
            fontSize = fontSize.sp,
            fontFamily = masterOutlinedFamily,
            style = TextStyle(
                brush = blueGradient
            )
        )
        Text(
            modifier = Modifier.padding(end = (fontSize/6).dp),
            text = "Tac",
            fontSize = fontSize.sp,
            fontFamily = masterOutlinedFamily,
            style = TextStyle(
                brush = whiteGradient
            )
        )
        Text(
            modifier = Modifier,
            text = "Toe",
            fontSize = fontSize.sp,
            fontFamily = masterOutlinedFamily,
            style = TextStyle(
                brush = orangeGradient
            )
        )
    }

}

@Preview
@Composable
fun LogoPreview(){
    GameLogo(fontSize = 56)
}