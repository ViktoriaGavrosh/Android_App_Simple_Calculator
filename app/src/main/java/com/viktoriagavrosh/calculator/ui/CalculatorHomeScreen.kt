package com.viktoriagavrosh.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.viktoriagavrosh.calculator.R
import com.viktoriagavrosh.calculator.data.DataSource
import com.viktoriagavrosh.calculator.model.CalculateButton
import com.viktoriagavrosh.calculator.ui.elements.ButtonPanel
import com.viktoriagavrosh.calculator.ui.elements.CountingField
import com.viktoriagavrosh.calculator.ui.theme.CalculatorTheme
import com.viktoriagavrosh.calculator.viewmodel.CalculateUiState
import com.viktoriagavrosh.calculator.viewmodel.CalculateViewModel

@Composable
fun CalculatorHomeScreen(
    listAllButtons: List<List<CalculateButton>>,
    viewModel: CalculateViewModel,
    uiState: CalculateUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        CountingField(
            uiState = uiState,
            modifier = Modifier.weight(1F)
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))
        ButtonPanel(
            listAllButtons = listAllButtons,
            viewModel = viewModel,
            modifier = Modifier.weight(2F)
        )
    }
}

@Preview(widthDp = 1000)
@Composable
fun CalculatorHomeScreenPreview() {
    CalculatorTheme {
        CalculatorHomeScreen(
            listAllButtons = DataSource.listButtons,
            viewModel = CalculateViewModel(),
            uiState = CalculateUiState()
        )
    }
}