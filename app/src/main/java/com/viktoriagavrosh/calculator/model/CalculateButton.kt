package com.viktoriagavrosh.calculator.model

import androidx.annotation.StringRes
import com.viktoriagavrosh.calculator.R

class CalculateButton(
    @StringRes val textId: Int,
    val type: CalculateButtonType,
    @StringRes val exceptionMessageId: Int = R.string.invalid_input_format
)