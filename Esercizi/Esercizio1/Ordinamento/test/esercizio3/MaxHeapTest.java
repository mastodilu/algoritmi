/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3;

import esercizio3.heapelementexceptions.NullContentException;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class MaxHeapTest {
    
    public MaxHeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of prior method, of class MaxHeap.
     */
    @Test
    public void testPrior() {
        testArray();
        testEmpty();
        testString();
    }
    
    private void testArray(){
        System.out.println("Test MaxHeap with arraylist");
        try{
            HeapElement[] array = {
                new HeapElement(3),
                new HeapElement(5),
                new HeapElement(9),
                new HeapElement(4),
                new HeapElement(8),
                new HeapElement(1),
                new HeapElement(2),
                new HeapElement(1)
                };
            ArrayList<HeapElement> expected = new ArrayList<HeapElement>();
            expected.add(new HeapElement(9));
            expected.add(new HeapElement(8));
            expected.add(new HeapElement(5));
            expected.add(new HeapElement(3));
            expected.add(new HeapElement(4));
            expected.add(new HeapElement(1));
            expected.add(new HeapElement(2));
            expected.add(new HeapElement(1));
            MaxHeap maxh = new MaxHeap(array);
            System.out.println("Array: " + maxh.toString());
            compareArrayList(maxh.getElements(), expected);
        }catch(NullContentException e){
            System.err.println(e.getMessage());
        }
    }
    
    
    private void testEmpty() {
        System.out.println("Test MaxHeap with empty data");
        MaxHeap maxh = new MaxHeap();
        maxh.heapInsert(null);
        maxh.heapInsert(null);
        maxh.heapInsert(null);
        ArrayList<HeapElement> expected = new ArrayList<HeapElement>();
        compareArrayList(maxh.getElements(), expected);
    }
    

    private void testString() {
        System.out.println("Test MaxHeap with Strings");
        MaxHeap maxh = new MaxHeap();
        try{
            maxh.heapInsert(new HeapElement("miao"));
            maxh.heapInsert(new HeapElement("ciao"));
            maxh.heapInsert(new HeapElement("CASTORO"));
            ArrayList<HeapElement> expected = new ArrayList<HeapElement>();
            expected.add(new HeapElement("miao"));
            expected.add(new HeapElement("ciao"));
            expected.add(new HeapElement("CASTORO"));
            compareArrayList(maxh.getElements(), expected);
        }catch(NullContentException e){
            System.err.println(e.getMessage());
        }
    }
    

    
    

    
    private void compareArrayList(ArrayList<HeapElement> first, ArrayList<HeapElement> second){
        assertEquals(first.size(), second.size());
        for(int i = 0; i < first.size(); i++){
            HeapElement one = first.get(i), two = second.get(i);
            System.out.println(one.toString() + " = " + two.toString());
            if(!first.get(i).isEqualTo(second.get(i)))
                fail("heap elements are different.");
        }
    }

    
    
}