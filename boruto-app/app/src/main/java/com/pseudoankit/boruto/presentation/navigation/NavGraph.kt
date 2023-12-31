package com.pseudoankit.boruto.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pseudoankit.boruto.domain.repository.DataStoreRepository
import com.pseudoankit.boruto.presentation.navigation.Screen.Companion.DETAILS_ARGUMENT_KEY
import com.pseudoankit.boruto.presentation.screen.home.HomeScreen
import com.pseudoankit.boruto.presentation.screen.splash.SplashScreen
import com.pseudoankit.boruto.presentation.screen.welcome.WelcomeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Splash.route,
    dataStoreRepository: DataStoreRepository
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController, dataStoreRepository)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screen.Search.route) {

        }
    }
}