package com.pseudoankit.boruto.presentation.navigation

sealed class Screen(val route: String) {

    companion object {
        const val DETAILS_ARGUMENT_KEY = "heroId"
    }

    data object Splash : Screen("splash_screen")
    data object Welcome : Screen("welcome_screen")
    data object Home : Screen("home_screen")
    data object Details : Screen("details_screen/{heroId}") {
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }

    data object Search : Screen("search_screen")
}