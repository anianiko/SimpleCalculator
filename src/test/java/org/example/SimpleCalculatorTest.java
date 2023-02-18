package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleCalculatorTest {

    @Test
    void testIsNumberNotValid() {
        assertFalse(SimpleCalculator.isNumber("x"));
    }

    @Test
    void testIsNumberIntegerValid() {
        assertTrue(SimpleCalculator.isNumber("2"));
    }

    @Test
    void testIsNumberNegativeIntegerValid() {
        assertTrue(SimpleCalculator.isNumber("-12"));
    }

    @Test
    void testIsNumberFloatValid() {
        assertTrue(SimpleCalculator.isNumber("17.6"));
    }

    @Test
    void testIsNumberNegativeFloatValid() {
        assertTrue(SimpleCalculator.isNumber("-99.99"));
    }

    @Test
    void testConvertNumberInteger() {
        assertEquals(SimpleCalculator.convertNumber("15"), Float.valueOf(15f));
    }

    @Test
    void testConvertNumberNegativeInteger() {
        assertEquals(SimpleCalculator.convertNumber("-615"), Float.valueOf(-615f));
    }

    @Test
    void testConvertNumberFloat() {
        assertEquals(SimpleCalculator.convertNumber("8.88"), Float.valueOf(8.88f));
    }

    @Test
    void testConvertNumberNegativeFloat() {
        assertEquals(SimpleCalculator.convertNumber("-4.45"), Float.valueOf(-4.45f));
    }

    @Test
    void testIsValidOperatorValid1() {
        assertTrue(SimpleCalculator.isValidOperator("+"));
    }

    @Test
    void testIsValidOperatorValid2() {
        assertTrue(SimpleCalculator.isValidOperator("-"));
    }

    @Test
    void testIsValidOperatorValid3() {
        assertTrue(SimpleCalculator.isValidOperator("/"));
    }

    @Test
    void testIsValidOperatorValid4() {
        assertTrue(SimpleCalculator.isValidOperator("*"));
    }

    @Test
    void testIsValidOperatorNotValid1() {
        assertFalse(SimpleCalculator.isValidOperator("%"));
    }

    @Test
    void testIsValidOperatorNotValid2() {
        assertFalse(SimpleCalculator.isValidOperator("t"));
    }

    @Test
    void testCalcPlus1() {
        float a = 3;
        float b = 4;
        assertEquals((Float)(a + b), SimpleCalculator.calc("+", a, b));
    }

    @Test
    void testCalcPlus2() {
        float a = -3;
        float b = 4;
        assertEquals((Float)(a + b), SimpleCalculator.calc("+", a, b));
    }

    @Test
    void testCalcPlus3() {
        float a = -3;
        float b = -4;
        assertEquals((Float)(a + b), SimpleCalculator.calc("+", a, b));
    }

    @Test
    void testCalcMinus1() {
        float a = 3;
        float b = 4;
        assertEquals((Float)(a - b), SimpleCalculator.calc("-", a, b));
    }

    @Test
    void testCalcMinus2() {
        float a = -3;
        float b = 4;
        assertEquals((Float)(a - b), SimpleCalculator.calc("-", a, b));
    }

    @Test
    void testCalcMinus3() {
        float a = 3;
        float b = -4;
        assertEquals((Float)(a - b), SimpleCalculator.calc("-", a, b));
    }

    @Test
    void testCalcMinus4() {
        float a = -3;
        float b = -4;
        assertEquals((Float)(a - b), SimpleCalculator.calc("-", a, b));
    }

    @Test
    void testCalcMultiply1() {
        float a = 3;
        float b = 4;
        assertEquals((Float)(a * b), SimpleCalculator.calc("*", a, b));
    }

    @Test
    void testCalcMultiply2() {
        float a = -3;
        float b = 4;
        assertEquals((Float)(a * b), SimpleCalculator.calc("*", a, b));
    }

    @Test
    void testCalcMultiply3() {
        float a = 3;
        float b = -4;
        assertEquals((Float)(a * b), SimpleCalculator.calc("*", a, b));
    }

    @Test
    void testCalcMultiply4() {
        float a = -3;
        float b = -4;
        assertEquals((Float)(a * b), SimpleCalculator.calc("*", a, b));
    }

    @Test
    void testCalcDivision1() {
        float a = 3;
        float b = 4;
        assertEquals((Float)(a / b), SimpleCalculator.calc("/", a, b));
    }

    @Test
    void testCalcDivision2() {
        float a = -3;
        float b = 4;
        assertEquals((Float)(a / b), SimpleCalculator.calc("/", a, b));
    }

    @Test
    void testCalcDivision3() {
        float a = 3;
        float b = -4;
        assertEquals((Float)(a / b), SimpleCalculator.calc("/", a, b));
    }

    @Test
    void testCalcDivision4() {
        float a = -3;
        float b = -4;
        assertEquals((Float)(a / b), SimpleCalculator.calc("/", a, b));
    }

    @Test
    void testCalcDivision5() {
        float a = 3;
        float b = 0;
        assertEquals(null, SimpleCalculator.calc("/", a, b));
    }

}
