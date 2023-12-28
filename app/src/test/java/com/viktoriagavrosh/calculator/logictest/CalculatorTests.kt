package com.viktoriagavrosh.calculator.logictest

import com.viktoriagavrosh.calculator.model.logic.calculateAll
import com.viktoriagavrosh.calculator.model.logic.convertToList
import com.viktoriagavrosh.calculator.model.logic.formatListForCount
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTests {

    @Test
    fun calculator_Add() {
        val expectAnswer = "8.5"
        val enteredString = "3+5.5"
        val actualAnswer = calculateAll(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_Subtract() {
        val expectAnswer = "2.24"
        val enteredString = "6.24-4"
        val actualAnswer = calculateAll(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_Multiply() {
        val expectAnswer = "10.6"
        val enteredString = "5.3*2"
        val actualAnswer = calculateAll(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_DivideInts() {
        val expectAnswer = "3.0"       // TODO
        val enteredString = "9/3"
        val actualAnswer = calculateAll(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_DivideDoubles() {
        val expectAnswer = "1.560655737704918"     // TODO
        val enteredString = "9.52/6.1"
        val actualAnswer = calculateAll(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test(expected = IllegalArgumentException::class)
    fun calculate_DivideByZero_IllegalArgumentException() {
        val enteredString = "9/0"
        calculateAll(enteredString)
    }

    @Test
    fun calculator_Expression() {
        val expectAnswer = "11.93"
        val enteredString = "6*2-5.65+1.8*0.6+9/2"
        val actualAnswer = calculateAll(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_SignFirst() {
        val expectAnswer = "-5.0"       // TODO
        val enteredString = "-8+3"
        val actualAnswer = calculateAll(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_ConvertToList() {
        val expectAnswer = listOf("36", "+", "64.1","-", "12", "*", "1.3", "/", "2")
        val enteredString = "36+64.1-12*1.3/2"
        val actualAnswer = convertToList(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_FormatListWithFirstSign_AddZero() {
        val expectAnswer = listOf("0", "-", "36", "+", "64.1")
        val enteredString = listOf("-", "36", "+", "64.1")
        val actualAnswer = formatListForCount(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }

    @Test
    fun calculator_FormatListWithLastSign_RemoveLastSign() {
        val expectAnswer = listOf("36", "+", "64.1")
        val enteredString = listOf("36", "+", "64.1", "-")
        val actualAnswer = formatListForCount(enteredString)
        assertEquals(expectAnswer, actualAnswer)
    }
}
