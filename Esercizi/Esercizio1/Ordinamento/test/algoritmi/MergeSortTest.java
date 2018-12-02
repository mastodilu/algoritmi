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
        al = new ArrayList<Long>(Arrays.asList(5L, 2L, 3L));
        result = new ArrayList<Long>(Arrays.asList(2L,3L,5L));
        MergeSort instance = new MergeSort(al);
        checkArrayListsLong(al, result);
        
        instance.sort();
    }
    
    
    /**
     * controlla che i due arraylist siano uguali
     * @param first il primo arraylist
     * @param second il secondo arraylist
     */
    private void checkArrayListsLong(ArrayList<Long> first, ArrayList<Long> second){
        long sizeofFirst = first.size();
        long sizeofSecond = second.size();
        assert(sizeofFirst == sizeofSecond);
        
        for(int i = 0; i < sizeofFirst; i++){
            assertEquals(first.get(i), second.get(i));
        }
    }
    
}
