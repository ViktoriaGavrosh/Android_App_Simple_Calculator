package com.viktoriagavrosh.calculator.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.viktoriagavrosh.calculator.R
import com.viktoriagavrosh.calculator.ui.theme.CalculatorTheme
import com.viktoriagavrosh.calculator.viewmodel.CalculateUiState

@Composable
fun CountingField(
    uiState: CalculateUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Card {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.counting_field_height))
                    .padding(dimensionResource(id = R.dimen.padding_large))
                    .background(MaterialTheme.colorScheme.onPrimary),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text(
                    text = uiState.textOnCountingField,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
                    maxLines = 2
                )
            }
        }
        Spacer(modifier = Modifier.weight(1F))
    }
}

@Preview
@Composable
fun CountingFieldPreview() {
    CalculatorTheme {
        CountingField(
            uiState = CalculateUiState()
        )
    }
}