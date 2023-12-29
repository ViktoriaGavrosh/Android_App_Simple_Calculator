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
        val newListButtons = listNumbersButtons.toMutableList()
        newListButtons.add(3, listSignsButtons[0])
        newListButtons.add(7, listSignsButtons[1])
        newListButtons.add(11, listSignsButtons[2])
        newListButtons.add(12, listSignsButtons[3])
        newListButtons.add(14, listSignsButtons[4])
        newListButtons.add(15, listSignsButtons[5])
        newListButtons.add(16, listSignsButtons[6])
        return newListButtons.chunked(4)
    }

    fun getHorizontalListButton(): List<List<CalculateButton>> {
        val newListButtons = listNumbersButtons.toMutableList()
        newListButtons.add(5, listSignsButtons[3])
        newListButtons.add(11, listSignsButtons[4])
        newListButtons.add(12, listSignsButtons[0])
        newListButtons.add(13, listSignsButtons[1])
        newListButtons.add(14, listSignsButtons[2])
        newListButtons.add(15, listSignsButtons[5])
        newListButtons.add(16, listSignsButtons[6])
        return newListButtons.chunked(6)
    }
}