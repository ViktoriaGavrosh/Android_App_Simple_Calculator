package com.viktoriagavrosh.calculator

import com.viktoriagavrosh.calculator.data.DataSource
import com.viktoriagavrosh.calculator.model.CalculateButtonType
import com.viktoriagavrosh.calculator.ui.utils.CalculateScreenType
import com.viktoriagavrosh.calculator.viewmodel.CalculateViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class CalculateViewModelTests {

    private val viewModel = CalculateViewModel()

    @Test
    fun calculateViewModel_InitVerticalListButtons() {
        val expectedListButtons = DataSource.getVerticalListButtons()
        val screenType = CalculateScreenType.VERTICAL
        viewModel.initListButtons(screenType)
        val currentCalculateUiState = viewModel.uiState.value
        assertEquals(expectedListButtons, currentCalculateUiState.listButtons)
    }

    @Test
    fun calculateViewModel_InitHorizontalListButtons() {
        val expectedListButtons = DataSource.getHorizontalListButton()
        val screenType = CalculateScreenType.HORIZONTAL
        viewModel.initListButtons(screenType)
        val currentCalculateUiState = viewModel.uiState.value
        assertEquals(expectedListButtons, currentCalculateUiState.listButtons)
    }

    @Test
    fun calculateViewModel_FirstEnterString_UiStateUpdated() {
        val inputText = "3"
        val buttonType = CalculateButtonType.PRINT
        viewModel.getFunctionOnButtonClick(inputText, buttonType)
        val currentCalculateUiState = viewModel.uiState.value
        assertEquals(inputText, currentCalculateUiState.textOnCountingField)
        assertFalse(currentCalculateUiState.isFirstInput)
    }

    @Test
    fun calculateViewModel_SecondEnterString_UiStateUpdated() {
        val expectedText = "3+"
        val firstInputText = "3"
        val buttonType = CalculateButtonType.PRINT
        viewModel.getFunctionOnButtonClick(firstInputText, buttonType)
        val secondInputText = "+"
        viewModel.getFunctionOnButtonClick(secondInputText, buttonType)
        val currentCalculateUiState = viewModel.uiState.value
        assertEquals(expectedText, currentCalculateUiState.textOnCountingField)
    }

    @Test
    fun calculateViewModel_Calculate_UiStateUpdated() {
        val expectedText = "8"
        val firstInput = "3"
        val secondInput = "+"
        val thirdInput = "5"
        viewModel.getFunctionOnButtonClick(firstInput, CalculateButtonType.PRINT)
        viewModel.getFunctionOnButtonClick(secondInput, CalculateButtonType.PRINT)
        viewModel.getFunctionOnButtonClick(thirdInput, CalculateButtonType.PRINT)
        viewModel.getFunctionOnButtonClick("", CalculateButtonType.EQUAL)
        val currentCalculateUiState = viewModel.uiState.value
        assertEquals(expectedText, currentCalculateUiState.textOnCountingField)
    }

    // TODO CalculateWithDivideByZero

    @Test
    fun calculateViewModel_ClickBackButton_UiStateUpdated() {
        val expectedText = "3+"
        val firstInput = "3"
        val secondInput = "+"
        val thirdInput = "5"
        viewModel.getFunctionOnButtonClick(firstInput, CalculateButtonType.PRINT)
        viewModel.getFunctionOnButtonClick(secondInput, CalculateButtonType.PRINT)
        viewModel.getFunctionOnButtonClick(thirdInput, CalculateButtonType.PRINT)
        viewModel.getFunctionOnButtonClick("", CalculateButtonType.CLEAR)
        val currentCalculateUiState = viewModel.uiState.value
        assertEquals(expectedText, currentCalculateUiState.textOnCountingField)
    }

}