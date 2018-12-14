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
public class MinHeapTest {
    
    public MinHeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of prior method, of class MinHeap.
     */
    @Test
    public void testPrior() {
        testInsert();
    }
    
    
    private void testInsert(){
        System.out.println("Test MinHeap insert");
        ArrayList<HeapElement> input, expected;
        input = new ArrayList<HeapElement>();
        expected = new ArrayList<HeapElement>();
        
        MinHeap minh = new MinHeap(input);
        try{
            minh.heapInsert(new HeapElement(3));
            minh.heapInsert(new HeapElement(5));
            minh.heapInsert(new HeapElement(9));
            minh.heapInsert(new HeapElement(4));
            minh.heapInsert(new HeapElement(8));
            minh.heapInsert(new HeapElement(1));
            minh.heapInsert(new HeapElement(2));
            minh.heapInsert(new HeapElement(1));

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
        }catch(NullContentException e){
            System.err.println(e.getMessage());
        }
        
    }
        
        
        
        
    private void compareArrayList(ArrayList<HeapElement> first, ArrayList<HeapElement> second){
        assertEquals(first.size(), second.size());
        for(int i = 0; i < first.size(); i++){
            HeapElement one = first.get(i), two = second.get(i);
            if(!first.get(i).isEqualTo(second.get(i)))
                fail("Heap elements are different.");
        }
    }
    
}
