/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3;

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
        testArrayList();
        testInsert();
        testEmpty();
        testString();
        testStringAndPriority();
    }
    
    
    private void testInsert(){
        System.out.println("Test MinHeap insert");
        ArrayList<HeapElement> input, expected;
        input = new ArrayList<HeapElement>();
        expected = new ArrayList<HeapElement>();
        
        MinHeap minh = new MinHeap(input);
        
        minh.heapInsert(new HeapElement(3));
        minh.heapInsert(new HeapElement(5));
        minh.heapInsert(new HeapElement(9));
        minh.heapInsert(new HeapElement(4));
        minh.heapInsert(new HeapElement(8));
        minh.heapInsert(new HeapElement(1));
        minh.heapInsert(new HeapElement(2));
        minh.heapInsert(new HeapElement(1));
        
        expected.add(null); // nello heap il primo elemento e' sempre null
        expected.add(new HeapElement(1));
        expected.add(new HeapElement(1));
        expected.add(new HeapElement(2));
        expected.add(new HeapElement(4));
        expected.add(new HeapElement(8));
        expected.add(new HeapElement(9));
        expected.add(new HeapElement(3));
        expected.add(new HeapElement(5 ));
        
        //System.out.println("Array: " + minh.toString());
        compareArrayList(minh.getElements(), expected);
        
    }
    
    private void testArrayList(){
        System.out.println("Test MaxHeap with arraylist");
        ArrayList<HeapElement> input, expected;
        input = new ArrayList<HeapElement>();
        expected = new ArrayList<HeapElement>();
        
        input.add(new HeapElement(3));
        input.add(new HeapElement(5));
        input.add(new HeapElement(9));
        input.add(new HeapElement(4));
        input.add(new HeapElement(8));
        input.add(new HeapElement(1));
        input.add(new HeapElement(2));
        input.add(new HeapElement(1));
        
        MinHeap minh = new MinHeap(input);
        
        expected.add(null); // nello heap il primo elemento e' sempre null
        expected.add(new HeapElement(1));
        expected.add(new HeapElement(1));
        expected.add(new HeapElement(2));
        expected.add(new HeapElement(4));
        expected.add(new HeapElement(8));
        expected.add(new HeapElement(9));
        expected.add(new HeapElement(3));
        expected.add(new HeapElement(5 ));
        
        System.out.println("Array: " + minh.toString());
        compareArrayList(minh.getElements(), expected);
    }
    
    private void testArray(){
        System.out.println("Test MaxHeap with arraylist");
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
        expected.add(null); // nello heap il primo elemento e' sempre null
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
    }
    
    
    
    private void compareArrayList(ArrayList<HeapElement> first, ArrayList<HeapElement> second){
        assertEquals(first.size(), second.size());
        for(int i = 1; i < first.size(); i++){
            HeapElement one = first.get(i), two = second.get(i);
            System.out.println(one.toString() + " = " + two.toString());
            if(!first.get(i).isEqualTo(second.get(i)))
                fail("heap elements are different.");
        }
    }

    private void testEmpty() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void testString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void testStringAndPriority() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
