package com.viktoriagavrosh.calculator.viewmodel

import androidx.lifecycle.ViewModel
import com.viktoriagavrosh.calculator.data.DataSource.getHorizontalListButton
import com.viktoriagavrosh.calculator.data.DataSource.getVerticalListButtons
import com.viktoriagavrosh.calculator.model.CalculateButtonType
import com.viktoriagavrosh.calculator.model.logic.calculateAll
import com.viktoriagavrosh.calculator.model.logic.checkInput
import com.viktoriagavrosh.calculator.model.logic.deleteLastCharacter
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

    fun getFunctionOnButtonClickOrException(text: String, buttonType: CalculateButtonType) =
        when (buttonType) {
            CalculateButtonType.PRINT -> print(text)
            CalculateButtonType.EQUAL -> calculate()
            CalculateButtonType.CLEAR -> back()

        }

    private fun updateState() {
        _uiState.update {
            it.copy(
                textOnCountingField = START_VALUE_ON_COUNTING_SCREEN,
                isFirstInput = true
            )
        }
    }

    private fun print(input: String) {
        val text = if (_uiState.value.isFirstInput) {
            if (_uiState.value.textOnCountingField == "0"
                || input.last().isDigit()
            ) {
                input
            } else {
                "${_uiState.value.textOnCountingField}$input"
            }
        } else {
            "${_uiState.value.textOnCountingField}$input"
        }
        when (val newText = checkInput(text)) {
            "Wrong input" -> {
                _uiState.update {
                    it.copy(
                        textOnCountingField = START_VALUE_ON_COUNTING_SCREEN
                    )
                }
                throw IllegalArgumentException("Wrong input")
            }

            else -> {
                _uiState.update {
                    it.copy(
                        textOnCountingField = newText,
                        isFirstInput = false
                    )
                }
            }
        }
    }

    private fun calculate() {
        val result = calculateAll(_uiState.value.textOnCountingField)
        _uiState.update {
            it.copy(
                textOnCountingField = result,
                isFirstInput = true
            )
        }
    }

    private fun back() {
        val newText = deleteLastCharacter(_uiState.value.textOnCountingField)
        if (newText.isEmpty()) {
            updateState()
        } else {
            _uiState.update {
                it.copy(
                    textOnCountingField = newText
                )
            }
        }
    }
}