package com.lamda.tictactoe.ui.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class BoardViewModel() : ViewModel() {
    private val _gameBoard = mutableStateOf(
        listOf(
            listOf(CardType.ECard, CardType.ECard, CardType.ECard),
            listOf(CardType.ECard, CardType.ECard, CardType.ECard),
            listOf(CardType.ECard, CardType.ECard, CardType.ECard)
        )
    )
    val gameBoard: State<List<List<CardType>>> = _gameBoard
    private val _turn = mutableStateOf(CardType.XCard)
    val turn: State<CardType> = _turn

    private val _winner = MutableStateFlow<CardType?>(CardType.ECard)
    val winner: StateFlow<CardType?> = _winner


    fun switchTurn() {
        val currentTurn = turn.value
        if (currentTurn == CardType.XCard) {
            _turn.value = CardType.OCard
        } else {
            _turn.value = CardType.XCard
        }
    }

    fun updateBoard(
        turn: CardType,
        rowIndex: Int,
        columnIndex: Int,
    ) {
        val currentGameBoard = _gameBoard.value.toMutableList()
        val rowList = currentGameBoard[rowIndex].toMutableList()
        rowList[columnIndex] = turn
        currentGameBoard[rowIndex] = rowList.toList()
        _gameBoard.value = currentGameBoard

    }

    fun restartGame() {
        _gameBoard.value = listOf(
            listOf(CardType.ECard, CardType.ECard, CardType.ECard),
            listOf(CardType.ECard, CardType.ECard, CardType.ECard),
            listOf(CardType.ECard, CardType.ECard, CardType.ECard)
        )
        _turn.value = CardType.XCard
        checkForWinner()
    }

    fun checkForWinner() {
        val board = gameBoard.value

        // Define winning combinations
        val winningCombinations = listOf(
            // Rows
            listOf(0, 1, 2),
            listOf(3, 4, 5),
            listOf(6, 7, 8),
            // Columns
            listOf(0, 3, 6),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            // Diagonals
            listOf(0, 4, 8),
            listOf(2, 4, 6)
        )

        // Iterate through each winning combination
        for (combination in winningCombinations) {
            val (a, b, c) = combination
            if (board[a / 3][a % 3] != CardType.ECard &&
                board[a / 3][a % 3] == board[b / 3][b % 3] &&
                board[a / 3][a % 3] == board[c / 3][c % 3]
            ) {
                // Return the winning symbol
                _winner.value = board[a / 3][a % 3]
                stopGame()
                return
            }
        }

        // If no winner and the board is full, return null for a tie
        if (board.flatten().all { it != CardType.ECard }) {
            _winner.value = null
            return
        }

        // Otherwise, the game is ongoing
        _winner.value = CardType.ECard
    }

    fun stopGame() {
        // If there is a winner and there are still empty cells
        if (_gameBoard.value.flatten().any { it == CardType.ECard }) {
            // Create a mutable copy of the current game board
            val currentGameBoard = _gameBoard.value.map { it.toMutableList() }.toMutableList()

            // Replace empty cells with WCard
            for (rowIndex in currentGameBoard.indices) {
                for (columnIndex in currentGameBoard[rowIndex].indices) {
                    if (currentGameBoard[rowIndex][columnIndex] == CardType.ECard) {
                        currentGameBoard[rowIndex][columnIndex] = CardType.WinnerCard
                    }
                }
            }

            // Update the game board with the modified board
            _gameBoard.value = currentGameBoard
        }
    }
}