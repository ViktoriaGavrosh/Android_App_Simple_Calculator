package com.viktoriagavrosh.calculator.viewmodel

import com.viktoriagavrosh.calculator.model.CalculateButton

const val START_VALUE_ON_COUNTING_SCREEN = "0"

data class CalculateUiState(
    val listButtons: List<List<CalculateButton>> = emptyList(),
    val textOnCountingField: String = START_VALUE_ON_COUNTING_SCREEN,
    val isFirstInput: Boolean = true
)