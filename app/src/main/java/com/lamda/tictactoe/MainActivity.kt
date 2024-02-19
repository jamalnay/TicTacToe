package com.lamda.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

const val portrait = "portrait"
const val landscape = "landscape"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                val mode = remember { mutableStateOf("") }
                //BoxWithConstraints only used to detect the device orientation
                BoxWithConstraints {
                    mode.value = if (maxWidth < maxHeight) portrait else landscape
                }
                val navController: NavHostController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = AppScreens.SplashScreen.name
                ) {
                    composable(route = AppScreens.SplashScreen.name) {
                        SplashScreen(
                            navController = navController,
                            hideSystemBar = { hideSystemBars() },
                            mode = mode.value
                        )
                    }
                    composable(route = AppScreens.MainMenu.name) {
                        MainMenuScreen(
                            navController = navController,
                            onExit = { finish() },
                            showSystemBars = { showSystemBars() },
                            mode = mode.value
                        )
                    }
                    composable(route = AppScreens.GameBoard.name) {
                        GameBoard(
                            navController = navController,
                            mode = mode.value
                        )
                    }
                    composable(route = AppScreens.About.name) {
                        AboutScreen(
                            navController = navController,
                            mode = mode.value
                        )
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
