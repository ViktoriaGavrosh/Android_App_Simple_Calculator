package com.viktoriagavrosh.calculator.data

import com.viktoriagavrosh.calculator.R
import com.viktoriagavrosh.calculator.model.CalculateButton
import com.viktoriagavrosh.calculator.model.CalculateButtonType

object DataSource {
    private val listNumbersButtons = listOf(
        CalculateButton(
            textId = R.string.one,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.two,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.three,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.four,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.five,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.six,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.seven,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.eight,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.nine,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.zero,
            type = CalculateButtonType.PRINT
        )
    )

    private val listSignsButtons = listOf(
        CalculateButton(
            textId = R.string.add,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.subtract,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.multiply,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.clear,
            type = CalculateButtonType.CLEAR
        ),
        CalculateButton(
            textId = R.string.dot,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.divide,
            type = CalculateButtonType.PRINT
        ),
        CalculateButton(
            textId = R.string.equal,
            type = CalculateButtonType.EQUAL,
            exceptionMessageId = R.string.divide_by_zero
        )
    )

    fun getVerticalListButtons(): List<List<CalculateButton>> {
        val newListButtons = DataSource.listNumbersButtons.toMutableList()
        newListButtons.add(3, DataSource.listSignsButtons[0])
        newListButtons.add(7, DataSource.listSignsButtons[1])
        newListButtons.add(11, DataSource.listSignsButtons[2])
        newListButtons.add(12, DataSource.listSignsButtons[3])
        newListButtons.add(14, DataSource.listSignsButtons[4])
        newListButtons.add(15, DataSource.listSignsButtons[5])
        newListButtons.add(16, DataSource.listSignsButtons[6])
        return newListButtons.chunked(4)
    }

    fun getHorizontalListButton(): List<List<CalculateButton>> {
        val newListButtons = DataSource.listNumbersButtons.toMutableList()
        newListButtons.add(5, DataSource.listSignsButtons[3])
        newListButtons.add(11, DataSource.listSignsButtons[4])
        newListButtons.add(12, DataSource.listSignsButtons[0])
        newListButtons.add(13, DataSource.listSignsButtons[1])
        newListButtons.add(14, DataSource.listSignsButtons[2])
        newListButtons.add(15, DataSource.listSignsButtons[5])
        newListButtons.add(16, DataSource.listSignsButtons[6])
        return newListButtons.chunked(6)
    }
}