package com.lamda.tictactoe.ui.game.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lamda.tictactoe.landscape
import com.lamda.tictactoe.portrait
import com.lamda.tictactoe.ui.AppScreens
import com.lamda.tictactoe.ui.game.CardType
import com.lamda.tictactoe.ui.game.components.GameLogo
import com.lamda.tictactoe.ui.game.components.MicroXO
import com.lamda.tictactoe.ui.theme.Blue10
import com.lamda.tictactoe.ui.theme.Blue20
import com.lamda.tictactoe.ui.theme.Blue40
import com.lamda.tictactoe.ui.theme.Blue70
import com.lamda.tictactoe.ui.theme.Orange30
import com.lamda.tictactoe.ui.theme.masterFamily


@Composable
fun MainMenuScreen(
    navController: NavController,
    onExit: () -> Unit,
    showSystemBars: () -> Unit,
    mode:String
) {

    // Portrait  > aspectRation = 0.67
    // LandScape > aspectRation = 2.5
    val aspectRatio =  if (mode == portrait) 0.67f else 2.5f
    Card(
        modifier = Modifier
            .background(Blue70)
            .padding(vertical = 100.dp, horizontal = 60.dp)
            .fillMaxSize()
            .aspectRatio(aspectRatio),
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp)) {
                repeat(15) {
                    MicroXO(type = x, Modifier.weight(1f))
                    MicroXO(type = o, Modifier.weight(1f))
                }
            }

            if(mode == landscape){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 80.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GameLogo(
                        fontSize = 32
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(1 / 1.6f)
                                .border(
                                    border = BorderStroke(width = 1.dp, color = Color.White),
                                    shape = RoundedCornerShape(24.dp)
                                ),
                            onClick = {
                                navController.navigate(AppScreens.GameBoard.name)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue20,
                                contentColor = Color.White
                            ),
                            elevation = ButtonDefaults.buttonElevation(12.dp)
                        )
                        {
                            Text(
                                modifier = Modifier.padding(top=4.dp),
                                text = "New Game",
                                textAlign = TextAlign.Center,
                                fontFamily = masterFamily,
                                fontSize = 16.sp
                            )
                        }

                        Spacer(modifier = Modifier.padding(top = 12.dp))

                        Button(
                            modifier = Modifier
                                .fillMaxWidth(1 / 1.6f)
                                .border(
                                    border = BorderStroke(width = 1.dp, color = Color.White),
                                    shape = RoundedCornerShape(24.dp)
                                ),
                            onClick = {
                                navController.navigate(AppScreens.About.name)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue20,
                                contentColor = Color.White
                            ),
                            elevation = ButtonDefaults.buttonElevation(12.dp)
                        )
                        {
                            Text(
                                modifier = Modifier.padding(top=4.dp),
                                text = "About",
                                textAlign = TextAlign.Center,
                                fontFamily = masterFamily,
                                fontSize = 16.sp
                            )
                        }
                        Spacer(modifier = Modifier.padding(top = 12.dp))

                        Button(
                            modifier = Modifier
                                .fillMaxWidth(1 / 1.6f)
                                .border(
                                    border = BorderStroke(width = 1.dp, color = Color.White),
                                    shape = RoundedCornerShape(24.dp)
                                ),
                            onClick = {
                                onExit()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue20,
                                contentColor = Color.White
                            ),
                            elevation = ButtonDefaults.buttonElevation(12.dp)
                        )
                        {
                            Text(
                                modifier = Modifier.padding(top=4.dp),
                                text = "Exit",
                                textAlign = TextAlign.Center,
                                fontFamily = masterFamily,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }else{
                GameLogo(
                    fontSize = 32,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Text(
                    modifier = Modifier.padding(top=4.dp),
                    text = "1v1 Game",
                    textAlign = TextAlign.Center,
                    fontFamily = masterFamily,
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 40.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth(1 / 1.6f)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.White),
                            shape = RoundedCornerShape(24.dp)
                        ),
                    onClick = {
                        navController.navigate(AppScreens.GameBoard.name)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue20,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(12.dp)
                )
                {
                    Text(
                        modifier = Modifier.padding(top=4.dp),
                        text = "New Game",
                        textAlign = TextAlign.Center,
                        fontFamily = masterFamily,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.padding(top = 12.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth(1 / 1.6f)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.White),
                            shape = RoundedCornerShape(24.dp)
                        ),
                    onClick = {
                        navController.navigate(AppScreens.About.name)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue20,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(12.dp)
                )
                {
                    Text(
                        modifier = Modifier.padding(top=4.dp),
                        text = "About",
                        textAlign = TextAlign.Center,
                        fontFamily = masterFamily,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.padding(top = 12.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth(1 / 1.6f)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.White),
                            shape = RoundedCornerShape(24.dp)
                        ),
                    onClick = {
                        onExit()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue20,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(12.dp)
                )
                {
                    Text(
                        modifier = Modifier.padding(top=4.dp),
                        text = "Exit",
                        textAlign = TextAlign.Center,
                        fontFamily = masterFamily,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
    showSystemBars()
}