/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2.stringdistance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class StringsDistanceDynamicTest {
    
    public StringsDistanceDynamicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of evaluateDistance method, of class StringsDistanceDynamic.
     */
    @Test
    public void testEvaluateDistance() {
        System.out.println("evaluateDistance");
        String s1, s2;
        StringsDistanceDynamic instance;
        int expResult, result;
        
        //test 1
        s1 = "CASA";
        s2 = "CANE";
        instance = new StringsDistanceDynamic(s1,s2);
        expResult = 4;
        result = instance.evaluateDistance();
        System.out.println("edit distance dyn CASA CANE " + result);
        assertEquals(expResult, result);
        
        //test 2
        s1 = "CIAO";
        s2 = "";
        instance = new StringsDistanceDynamic(s1,s2);
        expResult = 4;
        result = instance.evaluateDistance();
        System.out.println("edit distance dyn CIAO '' " + result);
        assertEquals(expResult, result);
        
        //test 3
        s1 = "";
        s2 = "";
        instance = new StringsDistanceDynamic(s1,s2);
        expResult = 0;
        result = instance.evaluateDistance();
        System.out.println("edit distance dyn '' '' " + result);
        assertEquals(expResult, result);
        
        //test 4
        s1 = "casa";
        s2 = "cassa";
        instance = new StringsDistanceDynamic(s1,s2);
        expResult = 1;
        result = instance.evaluateDistance();
        System.out.println("edit distance dyn casa cassa " + result);
        assertEquals(expResult, result);
        
        //test 5
        s1 = "casa";
        s2 = "carta";
        instance = new StringsDistanceDynamic(s1,s2);
        expResult = 3;
        result = instance.evaluateDistance();
        System.out.println("edit distance dyn casa carta " + result);
        assertEquals(expResult, result);
//        instance.printMinOpType();
//        instance.printMinimumCosts();
//        instance.printNoopCosts();
//        instance.printCancCosts();
//        instance.printInsCosts();
    }
    
}
