/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class SumsFinderTest {
    
    public SumsFinderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testSomeMethod() {
        ArrayList<Long> numbers = new ArrayList<Long>(Arrays.asList(5L,2L,3L,7L,8L,5L,0L,89L,5L,4L,6L));
        ArrayList<Long> sums = new ArrayList<Long>(Arrays.asList(10L, 9L));
        SumsFinder ssfr = new SumsFinder(numbers, sums);
        System.out.println(ssfr.toString());
    }
    
}
