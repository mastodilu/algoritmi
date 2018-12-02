/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi;

import algoritmi.sumsfinder.Sum;
import algoritmi.sumsfinder.SumException;
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
        ArrayList<Long> numbers = new ArrayList<Long>(Arrays.asList(6L,10L,6L,20L,10L));
        ArrayList<Long> sums = new ArrayList<Long>(Arrays.asList(12L, 20L, 16L));
        ArrayList<Sum> expected = new ArrayList<Sum>();
        try{
            expected.add(new Sum(12L, 6L, 6L));
            expected.add(new Sum(20L, 10L, 10L));
            expected.add(new Sum(16L, 6L, 10L));
        }catch(SumException se){
            System.err.println(se.getMessage());
        }
        SumsFinder ssfr = new SumsFinder(numbers, sums);
        System.out.println(ssfr.toString());
        ssfr.findAddends();
        checkArraySums(ssfr.getSumList(), expected);
    }
    
    private void checkArraySums(ArrayList<Sum> first, ArrayList<Sum> second){
        int l1, l2;
        l1 = first.size();
        l2 = second.size();
        assert(l1 == l2);
        
        for(int i = 0; i < l1; i++){
            assert( first.get(i).sameFields(second.get(i)) == true );
        }
    }
    
}
