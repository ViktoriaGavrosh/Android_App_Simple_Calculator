package com.viktoriagavrosh.calculator.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.viktoriagavrosh.calculator.R
import com.viktoriagavrosh.calculator.data.DataSource
import com.viktoriagavrosh.calculator.model.CalculateButton
import com.viktoriagavrosh.calculator.ui.theme.CalculatorTheme
import com.viktoriagavrosh.calculator.viewmodel.CalculateViewModel

@Composable
fun ButtonPanel(
    listAllButtons: List<List<CalculateButton>>,
    viewModel: CalculateViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            for (listButtons in listAllButtons) {
                ButtonRow(
                    listButtons = listButtons,
                    viewModel = viewModel,
                    modifier = Modifier
                        .weight(1F)
                )
            }
        }
    }
}

@Composable
private fun ButtonRow(
    listButtons: List<CalculateButton>,
    viewModel: CalculateViewModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.padding_small)
        )
    ) {
        for (button in listButtons) {
            val text = stringResource(id = button.textId)
            TextButton(
                onClick = {
                    viewModel.getFunctionOnButtonClick(
                        text = text,
                        buttonType = button.type
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1F)
            ) {
                Text(
                    text = stringResource(id = button.textId),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}


@Preview
@Composable
fun ButtonPanelPreview() {
    CalculatorTheme {
        ButtonPanel(
            listAllButtons = DataSource.listButtons,
            viewModel = CalculateViewModel()
        )
    }
}