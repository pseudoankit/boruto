package com.pseudoankit.boruto.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.pseudoankit.boruto.domain.repository.BorutoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val borutoRepository: BorutoRepository
) : ViewModel() {

    val getAllHeroes = borutoRepository.getAllHeroes()
}