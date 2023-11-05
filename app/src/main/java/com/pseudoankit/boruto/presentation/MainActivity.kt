package com.pseudoankit.boruto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.pseudoankit.boruto.presentation.navigation.NavGraph
import com.pseudoankit.boruto.presentation.ui.theme.BorutoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                )
            }
        }
    }
}

