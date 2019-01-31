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
public class StringsDistanceTest {
    
    public StringsDistanceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of editDistance method, of class StringsDistance.
     */
    @Test
    public void testEditDistance() {
        System.out.println("editDistance");
        StringsDistance instance;
        String s1, s2;
        int result, expResult;
                
        //test 1
        s1 = "CASA";
        s2 = "CANE";
        instance = new StringsDistance();
        expResult = 4;
        result = instance.evaluateDistance(s1, s2);
        assertEquals(expResult, result);
        System.out.println("edit distance CASA CANE " + result);
        
        //test 2
        s1 = "CIAO";
        s2 = "";
        instance = new StringsDistance();
        expResult = 4;
        result = instance.evaluateDistance(s1, s2);
        System.out.println("edit distance CIAO '' " + result);
        assertEquals(expResult, result);
        
        //test 3
        s1 = "";
        s2 = "";
        instance = new StringsDistance();
        expResult = 0;
        result = instance.evaluateDistance(s1, s2);
        System.out.println("edit distance '' '' " + result);
        assertEquals(expResult, result);
        
        //test 4
        s1 = "casa";
        s2 = "cassa";
        instance = new StringsDistance();
        expResult = 1;
        result = instance.evaluateDistance(s1, s2);
        System.out.println("edit distance casa cassa " + result);
        assertEquals(expResult, result);
        
        //test 5
        s1 = "casa";
        s2 = "cavalluccio";
        instance = new StringsDistance();
        expResult = 9;
        result = instance.evaluateDistance(s1, s2);
        System.out.println("edit distance casa cavalluccio " + result);
        assertEquals(expResult, result);
    }
}
