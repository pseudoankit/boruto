package com.pseudoankit.boruto.presentation.screen.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pseudoankit.boruto.R
import com.pseudoankit.boruto.domain.model.OnBoardingPage
import com.pseudoankit.boruto.presentation.navigation.Screen
import com.pseudoankit.boruto.presentation.ui.component.HorizontalPagerIndicator
import com.pseudoankit.boruto.presentation.ui.theme.EXTRA_LARGE_PADDING
import com.pseudoankit.boruto.presentation.ui.theme.PAGING_INDICATOR_SPACING
import com.pseudoankit.boruto.presentation.ui.theme.PAGING_INDICATOR_WIDTH
import com.pseudoankit.boruto.presentation.ui.theme.SMALL_PADDING
import com.pseudoankit.boruto.presentation.ui.theme.activeIndicatorColor
import com.pseudoankit.boruto.presentation.ui.theme.buttonBackgroundColor
import com.pseudoankit.boruto.presentation.ui.theme.descriptionColor
import com.pseudoankit.boruto.presentation.ui.theme.inactiveIndicatorColor
import com.pseudoankit.boruto.presentation.ui.theme.titleColor
import com.pseudoankit.boruto.presentation.ui.theme.welcomeScreenBackgroundColor

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    val viewModel = hiltViewModel<WelcomeViewModel>()
    val items = remember { OnBoardingPage.items }
    val pagerState = rememberPagerState { items.size }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(welcomeScreenBackgroundColor)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(10f)
        ) { index ->
            PagerScreen(onBoardingPage = items[index])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            pageCount = pagerState.pageCount,
            activeColor = activeIndicatorColor,
            inactiveColor = inactiveIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            isVisible = pagerState.currentPage == items.lastIndex
        ) {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Welcome.route) {
                    inclusive = true
                }
            }
            viewModel.onFinishPressed()
        }
    }
}

@Composable
private fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(R.string.on_boarding_image)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = titleColor,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = descriptionColor,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@ExperimentalAnimationApi
@Composable
private fun FinishButton(
    modifier: Modifier,
    isVisible: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = isVisible
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}