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
public class InsertionSortTest<T> {
    
    public InsertionSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of sort method, of class InsertionSort.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        
        InsertionSort instance;
        ArrayList<Long> al, result;
        
        //caso n. 1
        // caso normale
        al = new ArrayList<Long>(Arrays.asList(     1L,2L,8L,11L,1L ));
        result = new ArrayList<Long>(Arrays.asList( 1L,1L,2L,8L,11L ));
        instance = new InsertionSort(al);
        instance.sort();
        checkArrayListsLong(al, result);
        
        //caso n. 2
        //arraylist senza elementi
        al = new ArrayList<Long>(Arrays.asList());
        result = new ArrayList<Long>(Arrays.asList());
        instance = new InsertionSort(al);
        instance.sort();
        checkArrayListsLong(al, result);
        
        //caso n. 3
        //arraylist di stringhe
        ArrayList<String> sss = new ArrayList<String>(Arrays.asList("BB","AAAAA","AA","CCC"));
        ArrayList<String> rrr = new ArrayList<String>(Arrays.asList("AA","AAAAA","BB","CCC"));
        instance = new InsertionSort(sss);
        instance.sort();
        checkArrayListsString(sss, rrr);
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
    
    
    private void checkArrayListsString(ArrayList<String> first, ArrayList<String> second){
        long sizeofFirst = first.size();
        long sizeofSecond = second.size();
        assert(sizeofFirst == sizeofSecond);
        
        for(int i = 0; i < sizeofFirst; i++){
            assertEquals(first.get(i), second.get(i));
        }
        
    }
    
}
