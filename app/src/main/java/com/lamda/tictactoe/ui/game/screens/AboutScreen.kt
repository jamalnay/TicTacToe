package com.lamda.tictactoe.ui.game.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lamda.tictactoe.R
import com.lamda.tictactoe.landscape
import com.lamda.tictactoe.portrait
import com.lamda.tictactoe.ui.game.CardType
import com.lamda.tictactoe.ui.game.components.CloseIcon
import com.lamda.tictactoe.ui.game.components.GameLogo
import com.lamda.tictactoe.ui.game.components.MicroXO
import com.lamda.tictactoe.ui.theme.Blue10
import com.lamda.tictactoe.ui.theme.Blue40
import com.lamda.tictactoe.ui.theme.Blue70
import com.lamda.tictactoe.ui.theme.BlueShade90
import com.lamda.tictactoe.ui.theme.Orange30
import com.lamda.tictactoe.ui.theme.masterFamily

@Composable
fun AboutScreen(
    navController: NavController,
    mode: String,
) {
    val githubIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://github.com/jamalnay/TicTacToe")
    )
    val context = LocalContext.current
    val aspectRatio = if (mode == portrait) 0.67f else 2.5f
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
            Spacer(modifier = Modifier.padding(top = 12.dp))
            if (mode == landscape) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        modifier = Modifier.padding(bottom = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "About",
                            textAlign = TextAlign.Center,
                            fontFamily = masterFamily,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 20.dp
                            ),
                            text = "version (1.0)",
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Default,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.padding(top = 12.dp))

                        Text(
                            modifier = Modifier.padding(
                                horizontal = 20.dp
                            ),
                            text = stringResource(id = R.string.about),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Default,
                            fontSize = 14.sp,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.padding(top = 12.dp))

                        Row {
                            TextButton(
                                modifier = Modifier.padding(end = 8.dp),
                                onClick = { }
                            ) {
                                Text(
                                    text = "Rate Us",
                                    textAlign = TextAlign.Center,
                                    fontFamily = masterFamily,
                                    fontSize = 16.sp,
                                    color = BlueShade90
                                )
                            }
                            TextButton(
                                modifier = Modifier.padding(start = 8.dp),
                                onClick = {
                                    context.startActivity(githubIntent)
                                }) {
                                Text(
                                    text = "Source Code",
                                    textAlign = TextAlign.Center,
                                    fontFamily = masterFamily,
                                    fontSize = 16.sp,
                                    color = BlueShade90
                                )
                            }
                            TextButton(
                                modifier = Modifier.padding(start = 8.dp),
                                onClick = {
                                    navController.navigateUp()
                                }) {
                                Text(
                                    text = "GoBack",
                                    textAlign = TextAlign.Center,
                                    fontFamily = masterFamily,
                                    fontSize = 16.sp,
                                    color = BlueShade90
                                )
                            }
                        }
                    }
                }
            } else {
                CloseIcon(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 18.dp),
                    navController = navController
                )

                GameLogo(
                    fontSize = 32
                )

                Text(
                    text = "About",
                    textAlign = TextAlign.Center,
                    fontFamily = masterFamily,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(
                        horizontal = 20.dp
                    ),
                    text = "version (1.0)",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 12.dp))

                Text(
                    modifier = Modifier.padding(
                        horizontal = 20.dp
                    ),
                    text = stringResource(id = R.string.about),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 12.dp))

                Row {
                    TextButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = { }
                    ) {
                        Text(
                            text = "Rate Us",
                            textAlign = TextAlign.Center,
                            fontFamily = masterFamily,
                            fontSize = 16.sp,
                            color = BlueShade90
                        )
                    }

                    TextButton(
                        modifier = Modifier.padding(start = 8.dp),
                        onClick = {
                            context.startActivity(githubIntent)
                        }) {
                        Text(
                            text = "Source Code",
                            textAlign = TextAlign.Center,
                            fontFamily = masterFamily,
                            fontSize = 16.sp,
                            color = BlueShade90
                        )
                    }
                }
            }
        }
    }
}