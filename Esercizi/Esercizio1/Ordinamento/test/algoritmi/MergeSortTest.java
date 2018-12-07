/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi;

import esercizio1.algoritmi.MergeSort;
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
        
        //caso n.1 - ordine crescente
        al = new ArrayList<Long>(Arrays.asList(     5L,2L,3L,1L));
        result = new ArrayList<Long>(Arrays.asList( 1L,2L,3L,5L));
        MergeSort instance = new MergeSort(al);
        instance.sortAscending();
        checkLong(al, result);
        
        //caso n.2 - ordine crescente
        ArrayList<String> sss = new ArrayList<String>(Arrays.asList( "AAAA","AA","CC","BB"));
        ArrayList<String> rrr = new ArrayList<String>(Arrays.asList( "AA","AAAA","BB","CC"));
        instance = new MergeSort(sss);
        instance.sortAscending();
        checkString(sss, rrr);
        
        
        //caso n.3 - ordine decrescente
        al = new ArrayList<Long>(Arrays.asList(     5L,2L,3L,1L));
        result = new ArrayList<Long>(Arrays.asList( 5L,3L,2L,1L));
        instance = new MergeSort(al);
        instance.sortDescending();
        checkLong(al, result);
        
        //caso n.4 - ordine cderescente
        sss = new ArrayList<String>(Arrays.asList( "AAAA","AA","CC","BB"));
        rrr = new ArrayList<String>(Arrays.asList( "CC","BB","AAAA","AA"));
        instance = new MergeSort(sss);
        instance.sortDescending();
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
