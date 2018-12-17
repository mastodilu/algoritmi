/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio4.graphnode.Edge;
import esercizio4.graphnode.Weight;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class NonDirectedGraphTest {
    
    public NonDirectedGraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

        /**
     * Test of addLink method, of class DirectedGraph.
     */
    @Test
    public void testAddLink() throws Exception {
        System.out.println("addLink");
        
        NonDirectedGraph instance = new NonDirectedGraph();
        Weight weight = new Weight(3);
        instance.addNode("A");
        instance.addNode("B");
        Edge e = new Edge("A", "B", weight);
        
        instance.addEdge("A", "B", weight);
        instance.addEdge("B", "B", weight);
        
        assertEquals(instance.grade(), 4);
    }

    /**
     * Test of removeLink method, of class DirectedGraph.
     */
    @Test
    public void testRemoveLink() throws Exception {
        System.out.println("removeLink");
        
        NonDirectedGraph instance = new NonDirectedGraph();
        Weight weight = new Weight(3);
        instance.addNode("A");
        instance.addNode("B");
        instance.addNode("C");
        
        instance.addEdge("A", "B", weight);
        instance.addEdge("B", "C", weight);
        
        assertEquals(instance.grade(), 4);
        instance.removeEdge("B","A");
        assertEquals(instance.grade(), 2);
        instance.removeEdge("B","C");
        assertEquals(instance.grade(), 0);
    }

    /**
     * Test of isDirected method, of class DirectedGraph.
     */
    @Test
    public void testIsDirected() {
        System.out.println("isDirected");
        NonDirectedGraph instance = new NonDirectedGraph();
        boolean expResult = false;
        boolean result = instance.isDirected();
        assertEquals(expResult, result);
    }
    
    
    /**
     * test toString method.
     */
    @Test
    public void testToString() throws Exception{
        String a = "A";
        String b = "B";
        String c = "C";
        Weight weight = new Weight(3);
        NonDirectedGraph instance = new NonDirectedGraph();
        
        instance.addNode(a);
        instance.addNode(b);
        instance.addNode(c);
        
        instance.addEdge(a, b, weight);
        instance.addEdge(b, a, weight);
        instance.addEdge(b, c, weight);
        System.out.println(instance.toString());
    }
    
    
    /**
     * test weight method.
     */
    @Test
    public void testWeight() throws Exception{
        System.out.println("weight");
        String a = "A";
        String b = "B";
        String c = "C";
        NonDirectedGraph instance = new NonDirectedGraph();
        
        instance.addNode(a);
        instance.addNode(b);
        instance.addNode(c);
        
        instance.addEdge(a, b, new Weight(2));
        instance.addEdge(b, a, new Weight(3));
        instance.addEdge(b, c, new Weight(4));
        
        Integer expected = 18;
        
        assertEquals(expected, instance.weight());
    }
    
}
