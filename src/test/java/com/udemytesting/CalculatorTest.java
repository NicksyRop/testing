package com.udemytesting;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    @DisplayName("Test integer subtraction")
    @ParameterizedTest // use this if you want to pass params to the test method
    @MethodSource("integerSubtractionInputParameters") // method will run as number of inputs in the method source
    void testIntegerSubtraction(
            int manuend, int subtrahend, int expectedResult
    ) {

        int result = calculator.integerSubtraction(manuend, subtrahend);
        assertEquals(expectedResult,result, "Integer subtraction " + subtrahend + " did not produce "+ expectedResult);
    }

    //method source for input params
    private static Stream<Arguments> integerSubtractionInputParameters() {
        return Stream.of(
                Arguments.of(32,2,30),
                Arguments.of(50,2,48),
                Arguments.of(24,4,20)
        );
    }


    //another method to pass params using  @CsvSource
    //todo : this is easier

//todo : for strings nb if string is empty use ''
//    @CsvSource( {
//            "apple, orange",
//            "orange, ''", //empty
//            "orange, ", // null
//    } )

    @ParameterizedTest
    @DisplayName("Test integer subtraction passing params using csv file")
//    @CsvSource( {
//            "33,2,31",
//            "40,2,38"
//    } )
    @CsvFileSource(resources = "/integerSubtraction.csv") //todo (use csv file  if you have a long list of test data  (values comma seperated)
    void testIntegerSubtraction_WhenWePassParams( int manuend, int subtrahend, int expectedResult) {
        int result = calculator.integerSubtraction(manuend, subtrahend);
        assertEquals(expectedResult,result, "Integer subtraction " + subtrahend + " did not produce "+ expectedResult);
    }

    //value source allows us to supply one value from an array of values
    @ParameterizedTest
    @ValueSource(strings = {"john", "Cate", "Alice"})
    void valuesourceDemo(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }

}