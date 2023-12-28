package com.viktoriagavrosh.calculator.ui.elements

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.viktoriagavrosh.calculator.R
import com.viktoriagavrosh.calculator.data.DataSource
import com.viktoriagavrosh.calculator.model.CalculateButton
import com.viktoriagavrosh.calculator.model.CalculateButtonType
import com.viktoriagavrosh.calculator.ui.theme.CalculatorTheme
import com.viktoriagavrosh.calculator.ui.utils.CalculateScreenType
import com.viktoriagavrosh.calculator.viewmodel.CalculateViewModel

@Composable
fun ButtonPanel(
    listAllButtons: List<List<CalculateButton>>,
    screenType: CalculateScreenType,
    viewModel: CalculateViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement
                .spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            for (listButtons in listAllButtons) {
                ButtonRow(
                    listButtons = listButtons,
                    screenType = screenType,
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
    screenType: CalculateScreenType,
    viewModel: CalculateViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val textToast = stringResource(id = R.string.invalid_input_format)
    val displayToast = {
        Toast.makeText(context, textToast, Toast.LENGTH_SHORT).show()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        for (button in listButtons) {
            val text = stringResource(id = button.textId)
            ElevatedButton(
                onClick = {
                    try {
                        viewModel.getFunctionOnButtonClickOrException(
                            text = text,
                            buttonType = button.type
                        )
                        Log.e("ButtonWrongInput", text)
                    } catch (e: IllegalArgumentException) {
                        displayToast()
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(
                        if (button.type == CalculateButtonType.EQUAL
                            && screenType == CalculateScreenType.HORIZONTAL
                        ) 2F else 1F
                    ),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner))
            ) {
                Text(
                    text = stringResource(id = button.textId),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Preview(widthDp = 1000)
@Composable
fun ButtonPanelPreview() {
    CalculatorTheme {
        ButtonPanel(
            listAllButtons = DataSource.getHorizontalListButton(),
            screenType = CalculateScreenType.HORIZONTAL,
            viewModel = CalculateViewModel()
        )
    }
}

