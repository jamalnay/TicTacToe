package com.lamda.tictactoe.ui.game.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.lamda.tictactoe.ui.game.BoardViewModel
import com.lamda.tictactoe.ui.game.CardType
import com.lamda.tictactoe.ui.game.components.EmptyCard
import com.lamda.tictactoe.ui.game.components.GameLogo
import com.lamda.tictactoe.ui.game.components.OCard
import com.lamda.tictactoe.ui.game.components.PlayerTurnShape
import com.lamda.tictactoe.ui.game.components.WinnerCard
import com.lamda.tictactoe.ui.game.components.XCard
import com.lamda.tictactoe.ui.theme.Blue10Transparent
import com.lamda.tictactoe.ui.theme.Blue20
import com.lamda.tictactoe.ui.theme.Blue70
import com.lamda.tictactoe.ui.theme.BlueShade90
import com.lamda.tictactoe.ui.theme.masterFamily

@Composable
fun GameBoard(
    navController: NavController,
) {
    val boardViewModel: BoardViewModel = viewModel()
    val initialGameBoard = boardViewModel.gameBoard.value
    val turn = boardViewModel.turn.value
    val winner = boardViewModel.winner.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        GameLogo(
            fontSize = 32,
            modifier = Modifier
                .background(Blue20)
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .height(56.dp)
        )

        Column(
            modifier = Modifier
                .background(Blue70)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp)
                .background(Blue10Transparent)
                .padding(bottom = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                initialGameBoard.forEachIndexed() { rowIndex, row ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        row.forEachIndexed { columnIndex, cardType ->
                            when (cardType) {
                                CardType.XCard -> XCard(
                                    Modifier.weight(1f)
                                )

                                CardType.OCard -> OCard(
                                    Modifier.weight(1f)
                                )

                                CardType.ECard -> EmptyCard(
                                    Modifier.weight(1f),
                                    onClick = {
                                        boardViewModel.updateBoard(turn, rowIndex, columnIndex)
                                        boardViewModel.switchTurn()
                                        boardViewModel.checkForWinner()
                                    }
                                )

                                CardType.WinnerCard -> {
                                    WinnerCard(
                                        Modifier.weight(1f),
                                        winner.value
                                    )
                                }
                            }
                            if (columnIndex != 2) {
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (winner.value) {
                    CardType.XCard -> {
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = "X won the game",
                            textAlign = TextAlign.Center,
                            fontFamily = masterFamily,
                            fontSize = 16.sp,
                            color = BlueShade90
                        )
                        PlayerTurnShape(turn = null)
                    }

                    CardType.OCard -> {
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = "O won the game",
                            textAlign = TextAlign.Center,
                            fontFamily = masterFamily,
                            fontSize = 16.sp,
                            color = BlueShade90
                        )
                        PlayerTurnShape(turn = null)
                    }

                    null -> {
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = "A tie game",
                            textAlign = TextAlign.Center,
                            fontFamily = masterFamily,
                            fontSize = 16.sp,
                            color = BlueShade90
                        )
                        PlayerTurnShape(turn = null)
                    }

                    else -> {
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = "Current Turn",
                            textAlign = TextAlign.Center,
                            fontFamily = masterFamily,
                            fontSize = 16.sp,
                            color = BlueShade90
                        )
                        PlayerTurnShape(turn = turn)
                    }
                }
                Spacer(modifier = Modifier.height(72.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(1f / 2)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.White),
                            shape = RoundedCornerShape(24.dp)
                        ),
                    onClick = { boardViewModel.restartGame() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue20,
                        contentColor = Color.White
                    )

                ) {
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = "Restart Game",
                        textAlign = TextAlign.Center,
                        fontFamily = masterFamily,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(1f / 2)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.White),
                            shape = RoundedCornerShape(24.dp)
                        ),
                    onClick = {
                        navController.navigateUp()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue20,
                        contentColor = Color.White
                    )

                ) {
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = "Main Menu",
                        textAlign = TextAlign.Center,
                        fontFamily = masterFamily,
                        fontSize = 16.sp
                    )
                }
            }
        }

    }
}