package com.viktoriagavrosh.calculator.viewmodel

import androidx.lifecycle.ViewModel
import com.viktoriagavrosh.calculator.data.DataSource
import com.viktoriagavrosh.calculator.data.DataSource.getHorizontalListButton
import com.viktoriagavrosh.calculator.data.DataSource.getVerticalListButtons
import com.viktoriagavrosh.calculator.model.CalculateButton
import com.viktoriagavrosh.calculator.model.CalculateButtonType
import com.viktoriagavrosh.calculator.ui.utils.CalculateScreenType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CalculateViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculateUiState())
    val uiState: StateFlow<CalculateUiState> = _uiState

    fun initListButtons(screenType: CalculateScreenType) {
        val newListButton = if (screenType == CalculateScreenType.VERTICAL) {
            getVerticalListButtons()
        } else {
            getHorizontalListButton()
        }
        _uiState.update {
            it.copy(
                listButtons = newListButton
            )
        }
    }

    fun getFunctionOnButtonClick(text: String, buttonType: CalculateButtonType) =
        when (buttonType) {
            CalculateButtonType.PRINT -> print(text)
            CalculateButtonType.EQUAL -> count()
            CalculateButtonType.CLEAR -> back()
        }

    private fun print(input: String) {

    }

    private fun count() {

    }

    private fun back() {

    }


}