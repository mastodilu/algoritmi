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
//        System.out.println("editDistance");
//        String s1 = "";
//        String s2 = "";
//        StringsDistance instance = new StringsDistance();
//        int expResult = 0;
//        int result = instance.editDistance(s1, s2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of rest method, of class StringsDistance.
     */
    @Test
    public void testRest() {
        System.out.println("rest");
        StringsDistance instance = new StringsDistance();
        String expected = "IAO";
        String result = instance.rest("CIAO");
        assertEquals(result, expected);
    }
    
}
