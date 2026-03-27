package com.example.focussentinel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.focussentinel.ui.screens.*
import com.example.focussentinel.ui.theme.FocusSentinelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocusSentinelTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FocusSentinelApp()
                }
            }
        }
    }
}

@Composable
fun FocusSentinelApp(viewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    val userState by viewModel.userState.collectAsState()

    val startDestination = if (userState.isLoggedIn) "dashboard" else "login"

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("dashboard") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                viewModel = viewModel
            )
        }
        composable("dashboard") {
            DashboardScreen(
                viewModel = viewModel,
                onNavigateToBadges = { navController.navigate("badges") },
                onNavigateToFocus = { navController.navigate("focus") },
                onNavigateToChat = { navController.navigate("chat") },
                onNavigateToLeaderboard = { navController.navigate("leaderboard") },
                onNavigateToSettings = { navController.navigate("settings") },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo("dashboard") { inclusive = true }
                    }
                }
            )
        }
        composable("badges") {
            BadgesScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
        composable("focus") {
            FocusModeScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
        composable("chat") {
            ChatScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
        composable("leaderboard") {
            LeaderboardScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
        composable("settings") {
            SettingsScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
