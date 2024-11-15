package com.udemytesting;

import org.junit.jupiter.api.*;

/**
 * @author nnkipkorir
 * created 14/11/2024
 */


/**
 * @TestInstance(TestInstance.Lifecycle.PER_METHOD) IS The default (junit create new instance of an object for each test method.
 * The String builder object will create a new object (afresh) on the method level
 * in this case when the last test method run the StringBuilder object will be created afresh and
 *  4 qpended to it
 *
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS) will maintain a single object at method level
 * hence all the methods will update same object  "1234" when the last test run
 * in below sb will have
 *
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //todo : for intergration test use ordered so tests can run in the manner we want i.e insert then fetch
@Order(2)
public class MethodOrderedByOrderedIndexTest {
    StringBuilder sb = new StringBuilder();


    @AfterEach
    void afterEach(){
        System.out.println("The state of instance object is: " + sb);
    }

    @Order(1) //todo : run first
    @Test
    void testD(){
        System.out.println("Running testD");
        sb.append("1");
    }

    @Order(4)
    @Test
    void testA(){
        System.out.println("Running testA");
        sb.append("4");
    }

    @Order(2)
    @Test
    void testC(){
        System.out.println("Running testC");
        sb.append("2");
    }

    @Order(3)
    @Test
    void testB(){
        System.out.println("Running testB");
        sb.append("3");
    }
}
