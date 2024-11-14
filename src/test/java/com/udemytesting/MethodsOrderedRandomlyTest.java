package com.udemytesting;

import org.junit.jupiter.api.*;

/**
 * @author nnkipkorir
 * created 14/11/2024
 */

@DisplayName("Test to learn ordering of tests")
@Order(4)
//@TestMethodOrder(MethodOrderer.Random.class) //todo: randomly
@TestMethodOrder(MethodOrderer.MethodName.class) //todo: order using method name ascending
//@TestMethodOrder(MethodOrderer.MethodName.class) //todo: order using method name
public class MethodsOrderedRandomlyTest {

    @Test
    void testA(){
        System.out.println("Running testA");
    }

    @Test
    void testC(){
        System.out.println("Running testC");
    }

    @Test
    void testD(){
        System.out.println("Running testD");
    }

    @Test
    void testB(){
        System.out.println("Running testB");
    }
}
