package com.viktoriagavrosh.calculator.viewmodel

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.viktoriagavrosh.calculator.model.CalculateButton
import com.viktoriagavrosh.calculator.model.CalculateButtonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculateViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculateUiState())
    val uiState: StateFlow<CalculateUiState> = _uiState

    private fun print(input: String) {

    }

    private fun count() {

    }

    private fun back() {

    }

    fun getFunctionOnButtonClick(text: String, buttonType: CalculateButtonType) = when (buttonType) {
        CalculateButtonType.PRINT -> print(text)
        CalculateButtonType.EQUAL -> count()
        CalculateButtonType.CLEAR -> back()
        else -> print(text)
    }
}