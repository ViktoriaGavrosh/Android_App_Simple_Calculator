package com.viktoriagavrosh.calculator.data

import com.viktoriagavrosh.calculator.R
import com.viktoriagavrosh.calculator.model.CalculateButton
import com.viktoriagavrosh.calculator.model.CalculateButtonType

object DataSource {
    val listButtons = listOf(
        listOf(
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
                textId = R.string.add,
                type = CalculateButtonType.PRINT
            )
        ),
        listOf(
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
                textId = R.string.subtract,
                type = CalculateButtonType.PRINT
            )
        ),
        listOf(
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
                textId = R.string.multiply,
                type = CalculateButtonType.PRINT
            )
        ),
        listOf(
            CalculateButton(
                textId = R.string.clear,
                type = CalculateButtonType.CLEAR
            ),
            CalculateButton(
                textId = R.string.zero,
                type = CalculateButtonType.PRINT
            ),
            CalculateButton(
                textId = R.string.dot,
                type = CalculateButtonType.PRINT
            ),
            CalculateButton(
                textId = R.string.divide,
                type = CalculateButtonType.PRINT
            )
        ),
        listOf(
            CalculateButton(
                textId = R.string.equal,
                type = CalculateButtonType.EQUAL
            )
        )
    )
}