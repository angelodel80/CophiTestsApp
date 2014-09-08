/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angelodel80
 */
public class JavaApplication1Test {
    
    public JavaApplication1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of test method, of class JavaApplication1.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        JavaApplication1 instance = new JavaApplication1();
        instance.test("");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class JavaApplication1.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        JavaApplication1.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
