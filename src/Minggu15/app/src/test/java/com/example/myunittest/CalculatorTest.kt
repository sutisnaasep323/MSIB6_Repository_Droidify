package com.example.myunittest

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `test addition of two positive numbers`() {
        val result = calculator.add(5, 3)
        assertEquals(8, result)
    }

    @Test
    fun `test addition of positive and negative number`() {
        val result = calculator.add(5, -3)
        assertEquals(2, result)
    }

    @Test
    fun `test addition of negative and positive number`() {
        val result = calculator.add(-5, 3)
        assertEquals(-2, result)
    }

    @Test
    fun `test addition of two negative numbers`() {
        val result = calculator.add(-5, -3)
        assertEquals(-8, result)
    }

    @Test
    fun `test addition with zero`() {
        val result = calculator.add(5, 0)
        assertEquals(5, result)
    }
}