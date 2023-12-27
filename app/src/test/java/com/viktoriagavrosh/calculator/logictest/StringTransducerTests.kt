package com.viktoriagavrosh.calculator.logictest

import com.viktoriagavrosh.calculator.model.logic.checkInput
import com.viktoriagavrosh.calculator.model.logic.deleteLastCharacter
import org.junit.Assert.assertEquals
import org.junit.Test

class StringTransducerTests {

    @Test
    fun deleteLastCharacter_EnterCorrectString() {
        val expectedAnswer = "2+3+"
        val inputText = "2+3+4"
        val actualAnswer = deleteLastCharacter(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun deleteLastCharacter_EnterEmptyString() {
        val expectedAnswer = ""
        val inputText = ""
        val actualAnswer = deleteLastCharacter(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun checkInput_EnterCorrectString() {
        val expectedAnswer = "2+3+4"
        val inputText = "2+3+4"
        val actualAnswer = checkInput(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun checkInput_EnterEmptyString() {
        val expectedAnswer = ""
        val inputText = ""
        val actualAnswer = checkInput(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun checkInput_EnterTwoSigns_ChangeLastSign() {
        val expectedAnswer = "2+3+"
        val inputText = "2+3-+"
        val actualAnswer = checkInput(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun checkInput_EnterTwoDots_DeleteLastSign() {
        val expectedAnswer = "2+3+4."
        val inputText = "2+3+4.."
        val actualAnswer = checkInput(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun checkInput_EnterSignAfterDot_DeleteDot() {
        val expectedAnswer = "2+3+4+"
        val inputText = "2+3+4.+"
        val actualAnswer = checkInput(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun checkInput_EnterDotAfterSign_AddZeroBeforeDot() {
        val expectedAnswer = "2-3*4+0."
        val inputText = "2-3*4+."
        val actualAnswer = checkInput(inputText)
        assertEquals(expectedAnswer, actualAnswer)
    }
}