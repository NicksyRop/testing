package com.udemytesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author nnkipkorir
 * created 14/11/2024
 */

@DisplayName("Test to demonstrate repeated tests.")
public class DemoRepeatedTest {

    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @RepeatedTest(6)
    @DisplayName("Division by zero")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {
        //todo : we can repetition info or Test info  passed as args then inspect
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition info count " + repetitionInfo.getCurrentRepetition());
        //Arrange
        int dividend = 4;
        int divisor = 0;

        //Act and Assert
        //assertThrows expects an class and an executable which is a lambda function
        assertThrows(ArithmeticException.class, ()-> calculator.integerDivision(dividend, divisor),
                "Division by zero should throw an ArithmeticException");
    }
}
