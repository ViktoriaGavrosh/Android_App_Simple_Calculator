package com.viktoriagavrosh.calculator.model.logic

fun checkInput(text: String): String {
    if (text == "*" || text == "/" || text == ".") return "Wrong input"
    if (text == "" || text.length == 1) return text
    return checkLastCharacters(text)
}

fun deleteLastCharacter(text: String): String {
    return if (text == "") {
        text
    } else {
        text.substring(0, text.lastIndex)
    }
}

private fun checkLastCharacters(text: String): String {
    val lastCharacters = text[text.lastIndex - 1] to text.last()
    return if (
        lastCharacters.second != '.'
        && !lastCharacters.first.isDigit()
        && !lastCharacters.second.isDigit()
        ) {
        "${text.substring(0, text.lastIndex - 1)}${text.substring(text.lastIndex)}"
    } else {
        checkTwoDotsInNumber(text)
    }
}

private fun checkTwoDotsInNumber(text: String): String {
    if (!text[text.lastIndex - 1].isDigit() && text.last() == '.') {
        return text.substring(0, text.lastIndex)
    }
    val regex = Regex("[+\\-/*]")
    val textWithoutSigns = text.replace(regex, " ")
    val lastNumber = textWithoutSigns.split(" ").last()
    return if (lastNumber.filter { it == '.' }.length > 1) {
        text.substring(0, text.lastIndex)
    } else {
        text
    }
}