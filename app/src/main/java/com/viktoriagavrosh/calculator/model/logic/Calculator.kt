package com.viktoriagavrosh.calculator.model.logic

fun calculateAll(expression: String): String {
    val listElements = convertToList(expression)
    val result = calculate(listElements)
    return formatResult(result)
}

private fun calculate(listElements: List<String>): String {
    val listFirstResult = calculateMultiplyAndDivide(listElements)
    val listSecondResult = calculateAddAndSubtract(listFirstResult)
    return listSecondResult.joinToString()
}

private fun formatResult(res: String): String {
    val fractionalPart = res.substringAfter(".")
    val fractionalPartWithoutZero = fractionalPart.replace("0", "")
    return if (fractionalPartWithoutZero.isEmpty()) {
        res.substringBefore(".")
    } else {
        res
    }
}

private fun calculateMultiplyAndDivide(list: List<String>): List<String> {
    val resultList = list.toMutableList()
    var indexMultiply = resultList.indexOf("*")
    var indexDivide = resultList.indexOf("/")
    while (indexMultiply != -1 || indexDivide != -1) {
        if (indexDivide == -1 || indexMultiply != -1 && indexMultiply < indexDivide ) {
            resultList[indexMultiply - 1] = multiply(
                resultList[indexMultiply - 1].toDouble(),
                resultList[indexMultiply + 1].toDouble()
            ).toString()
            resultList.removeAt(indexMultiply + 1)
            resultList.removeAt(indexMultiply)
        } else {
            resultList[indexDivide - 1] = divide(
                resultList[indexDivide - 1].toDouble(),
                resultList[indexDivide + 1].toDouble()
            ).toString()
            resultList.removeAt(indexDivide + 1)
            resultList.removeAt(indexDivide)
        }
        indexMultiply = resultList.indexOf("*")
        indexDivide = resultList.indexOf("/")
    }
    return resultList
}

private fun calculateAddAndSubtract(list: List<String>): List<String> {
    val resultList = list.toMutableList()
    var indexAdd = resultList.indexOf("+")
    var indexSubtract = resultList.indexOf("-")
    while (indexAdd != -1 || indexSubtract != -1) {
        if (indexSubtract == -1 || indexAdd != -1 && indexAdd < indexSubtract ) {
            resultList[indexAdd - 1] = add(
                resultList[indexAdd - 1].toDouble(),
                resultList[indexAdd + 1].toDouble()
            ).toString()
            resultList.removeAt(indexAdd + 1)
            resultList.removeAt(indexAdd)
        } else {
            resultList[indexSubtract - 1] = subtract(
                resultList[indexSubtract - 1].toDouble(),
                resultList[indexSubtract + 1].toDouble()
            ).toString()
            resultList.removeAt(indexSubtract + 1)
            resultList.removeAt(indexSubtract)
        }
        indexAdd = resultList.indexOf("+")
        indexSubtract = resultList.indexOf("-")
    }
    return resultList
}

internal fun convertToList(expression: String): List<String> {
    val listResult: MutableList<String> = mutableListOf()
    var numberString = ""
    for (i in expression.indices) {
        when {
            expression[i].isDigit() -> {
                numberString += expression[i]
                if (i == expression.lastIndex) listResult.add(numberString)
            }

            expression[i] == '.' -> {
                if (i == expression.lastIndex) {
                    listResult.add(numberString)
                } else {
                    numberString += expression[i]
                }
            }

            else -> {
                if (i != 0) listResult.add(numberString)
                listResult.add(expression[i].toString())
                numberString = ""
            }
        }
    }
    return formatListForCount(listResult)
}

internal fun formatListForCount(listElements: List<String>): List<String> {
    val listResult = listElements.toMutableList()
    if (listElements.first() == "-" || listElements.first() == "+") {
        listResult.add(0, "0")
    }
    val regex = Regex("[+\\-/*]")
    if (regex.matches(listElements.last())) listResult.removeAt(listResult.lastIndex)
    return listResult
}

private fun add(first: Double, second: Double): Double {
    return first + second
}

private fun subtract(first: Double, second: Double): Double {
    return first - second
}

private fun multiply(first: Double, second: Double): Double {
    return first * second
}

private fun divide(first: Double, second: Double): Double {
    if (second == 0.0) throw IllegalArgumentException("Divide by 0")
    return first / second
}



