package com.viktoriagavrosh.calculator.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.viktoriagavrosh.calculator.ui.utils.CalculateScreenType
import com.viktoriagavrosh.calculator.viewmodel.CalculateViewModel

@Composable
fun CalculatorApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: CalculateViewModel = viewModel()
    val screenType = when (windowSize) {
        WindowWidthSizeClass.Expanded -> CalculateScreenType.HORIZONTAL
        else -> CalculateScreenType.VERTICAL
    }
    viewModel.initListButtons(screenType)
    val calculateUiState = viewModel.uiState.collectAsState().value

    CalculatorHomeScreen(
        listAllButtons = calculateUiState.listButtons,
        screenType = screenType,
        viewModel = viewModel,
        uiState = calculateUiState,
        modifier = modifier
    )
}