package com.udemytesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test math operations in Calculator class.")
class CalculatorTest {
    Calculator calculator;
    @BeforeAll
    static void setup(){
        System.out.println("Executing setup method.");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("Executing cleanup method.");
    }

    @BeforeEach // use method to initialize data/ reset data
    void beforeEachTestMethod(){
        System.out.println("Executing before each test method.");
        calculator = new Calculator();
    }

    @AfterEach //close db / clean up db if method added records to db
    void afterEachTestMethod(){
        System.out.println("Executing after each test method.");
    }

    @Test
    @DisplayName("Test 4/2 = 2")
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        //Arrange (GIVEN) - prepare all the needed variables and objects that are needed by system under test
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

        //Act (WHEN) -- invoke the method under test
        int result = calculator.integerDivision(dividend, divisor);

        //Assert (THEN) -- validate return value from method under test
        assertEquals(expectedResult, result, "Integer division " + dividend + "/"
                + divisor + " did not produce "+ expectedResult);  // (expected value , result) , message shows if test fail
    }

    @Test
    ///@Disabled("TODO: Still need to work on it.") //how to disable a test
    @DisplayName("Division by zero")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        //Arrange
        int dividend = 4;
        int divisor = 0;

        //Act and Assert
        //assertThrows expects an class and an executable which is a lambda function
        assertThrows(ArithmeticException.class, ()-> calculator.integerDivision(dividend, divisor),
        "Division by zero should throw an ArithmeticException");
    }
}