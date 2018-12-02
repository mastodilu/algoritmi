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
public class MergeSortTest {
    
    public MergeSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        ArrayList<Long> al;
        ArrayList<Long> result;
        
        //caso n.1 - normale
        al = new ArrayList<Long>(Arrays.asList(     5L,2L,3L,1L));
        result = new ArrayList<Long>(Arrays.asList( 1L,2L,3L,5L));
        MergeSort instance = new MergeSort(al);
        instance.sort();
        checkLong(al, result);
        
        //caso n.2
        ArrayList<String> sss = new ArrayList<String>(Arrays.asList( "AA", "CC", "BB"));
        ArrayList<String> rrr = new ArrayList<String>(Arrays.asList( "AA","BB","CC"));
        instance = new MergeSort(sss);
        instance.sort();
        checkString(sss, rrr);
    }
    
    
    /**
     * controlla che i due arraylist siano uguali
     * @param first il primo arraylist
     * @param second il secondo arraylist
     */
    private void checkLong(ArrayList<Long> first, ArrayList<Long> second){
        long sizeofFirst = first.size();
        long sizeofSecond = second.size();
        assert(sizeofFirst == sizeofSecond);
        
        for(int i = 0; i < sizeofFirst; i++){
            assertEquals(first.get(i), second.get(i));
        }
    }

    
    private void checkString(ArrayList<String> first, ArrayList<String> second) {
        long sizeofFirst = first.size();
        long sizeofSecond = second.size();
        assert(sizeofFirst == sizeofSecond);
        
        for(int i = 0; i < sizeofFirst; i++){
            assertEquals(first.get(i), second.get(i));
        }
    }
    
}
