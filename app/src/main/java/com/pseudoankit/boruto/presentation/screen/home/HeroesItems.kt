package com.pseudoankit.boruto.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.pseudoankit.boruto.domain.model.Hero
import com.pseudoankit.boruto.presentation.ui.component.RatingWidget

@Composable
fun HeroesItems(items: LazyPagingItems<Hero>) {
    RatingWidget(rating = 3.7)
}