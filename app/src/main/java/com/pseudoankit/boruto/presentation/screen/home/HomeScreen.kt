package com.pseudoankit.boruto.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.pseudoankit.boruto.R
import com.pseudoankit.boruto.presentation.navigation.Screen
import com.pseudoankit.boruto.presentation.ui.theme.topAppBarBackgroundColor
import com.pseudoankit.boruto.presentation.ui.theme.topAppBarContentColor

@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<HomeViewModel>()

    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopBar(
                onSearchClicked = {
                    navController.navigate(Screen.Search.route)
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HeroesItems(
                items = allHeroes
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = topAppBarContentColor
            )
        },
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = topAppBarBackgroundColor,
            actionIconContentColor = Color.White
        )
    )
}