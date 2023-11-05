package com.pseudoankit.boruto.presentation.screen.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(

) : ViewModel() {

    fun onFinishPressed() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

}