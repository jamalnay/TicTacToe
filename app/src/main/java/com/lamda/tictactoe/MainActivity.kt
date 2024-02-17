package com.lamda.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lamda.tictactoe.ui.AppScreens
import com.lamda.tictactoe.ui.game.screens.AboutScreen
import com.lamda.tictactoe.ui.game.screens.GameBoard
import com.lamda.tictactoe.ui.game.screens.MainMenuScreen
import com.lamda.tictactoe.ui.game.screens.SplashScreen
import com.lamda.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                val navController: NavHostController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = AppScreens.SplashScreen.name
                ) {
                    composable(route = AppScreens.SplashScreen.name) {
                        SplashScreen(
                            navController = navController,
                            hideSystemBar = { hideSystemBars() }
                        )
                    }
                    composable(route = AppScreens.MainMenu.name) {
                        MainMenuScreen(
                            navController = navController,
                            onExit = { finish() },
                            showSystemBars = { showSystemBars() }
                        )
                    }
                    composable(route = AppScreens.GameBoard.name) {
                        GameBoard(navController = navController)
                    }
                    composable(route = AppScreens.About.name) {
                        AboutScreen(navController = navController)
                    }
                }
            }
        }
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

    private fun showSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.show(WindowInsetsCompat.Type.systemBars())
    }
}
