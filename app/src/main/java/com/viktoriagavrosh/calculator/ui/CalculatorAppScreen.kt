package com.viktoriagavrosh.calculator.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.viktoriagavrosh.calculator.viewmodel.CalculateViewModel

@Composable
fun CalculatorApp(
    modifier: Modifier = Modifier
) {
    val viewModel: CalculateViewModel = viewModel()
    val calculateUiState = viewModel.uiState.collectAsState().value

    CalculatorHomeScreen(
        listAllButtons = calculateUiState.listAllButtons,
        viewModel = viewModel,
        uiState = calculateUiState,
        modifier = modifier
    )
}