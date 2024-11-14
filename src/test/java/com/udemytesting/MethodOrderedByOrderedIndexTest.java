package com.udemytesting;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author nnkipkorir
 * created 14/11/2024
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //todo : for intergration test use ordered so tests can run in the manner we want i.e insert then fetch
@Order(2)
public class MethodOrderedByOrderedIndexTest {

    @Order(1) //todo : run first
    @Test
    void testD(){
        System.out.println("Running testD");
    }

    @Order(4)
    @Test
    void testA(){
        System.out.println("Running testA");
    }

    @Order(2)
    @Test
    void testC(){
        System.out.println("Running testC");
    }

    @Order(3)
    @Test
    void testB(){
        System.out.println("Running testB");
    }
}
