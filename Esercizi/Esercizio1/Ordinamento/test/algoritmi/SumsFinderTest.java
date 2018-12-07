/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi;

import esercizio1.algoritmi.SumsFinder;
import esercizio1.algoritmi.sumsfinder.Sum;
import esercizio1.algoritmi.sumsfinder.SumException;
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
        //test n.1
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
        
        
        
        //test n.2
        numbers = new ArrayList<Long>(Arrays.asList(6L,10L,6L,20L,10L,15L,40L,100L,100L));
        sums = new ArrayList<Long>(Arrays.asList(12L, 20L, 508L, 140L, 55L));
        expected = new ArrayList<Sum>();
        try{
            expected.add(new Sum(12L, 6L, 6L));
            expected.add(new Sum(20L, 10L, 10L));
            expected.add(new Sum(140L, 100L, 40L));
            expected.add(new Sum(55L, 40L, 15L));
        }catch(SumException se){
            System.err.println(se.getMessage());
        }
        ssfr = new SumsFinder(numbers, sums);
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
            assert( first.get(i).isEqual(second.get(i)) == true );
        }
    }
    
}
