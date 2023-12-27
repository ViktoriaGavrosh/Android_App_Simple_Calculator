package com.viktoriagavrosh.calculator.model.logic

fun checkInput(text: String): String {
    val resultText = text
    return resultText
}

fun deleteLastCharacter(text: String): String {
    return if (text == "") {
        text
    } else {
        text.substring(0, text.lastIndex)
    }
}
