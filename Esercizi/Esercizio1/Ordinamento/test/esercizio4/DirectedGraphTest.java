/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio4.graphnode.Node;
import esercizio4.graphnode.Weight;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class DirectedGraphTest {
    
    public DirectedGraphTest() {
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
        
        Node from = new Node("A");
        Node to = new Node("B");
        Weight weight = new Weight(3d);
        DirectedGraph instance = new DirectedGraph();
        
        instance.addNode(from);
        instance.addNode(to);
        
        instance.addLink(from, to, weight);
        instance.addLink(to, from, weight);
        
        System.out.println("grado " + instance.grade());
        
        assertEquals(instance.grade(), 2);
    }

    /**
     * Test of removeLink method, of class DirectedGraph.
     */
    @Test
    public void testRemoveLink() throws Exception {
        System.out.println("removeLink");
        
        Node from = new Node("A");
        Node to = new Node("B");
        Weight weight = new Weight(3d);
        DirectedGraph instance = new DirectedGraph();
        
        instance.addNode(from);
        instance.addNode(to);
        
        instance.addLink(from, to, weight);
        instance.addLink(to, from, weight);
        
        assertEquals(instance.grade(), 2);
        
        instance.removeLink(from, to);
        assertEquals(instance.grade(), 1);
        
        instance.removeLink(to, from);
        assertEquals(instance.grade(), 0);
    }

    /**
     * Test of isDirected method, of class DirectedGraph.
     */
    @Test
    public void testIsDirected() {
        System.out.println("isDirected");
        DirectedGraph instance = new DirectedGraph();
        boolean expResult = true;
        boolean result = instance.isDirected();
        assertEquals(expResult, result);
    }
    
    
    /**
     * test toString method.
     */
    @Test
    public void testToString() throws Exception{
        System.out.println("toString");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Weight weight = new Weight(3d);
        DirectedGraph instance = new DirectedGraph();
        
        instance.addNode(a);
        instance.addNode(b);
        instance.addNode(c);
        
        instance.addLink(a, b, weight);
        instance.addLink(b, a, weight);
        instance.addLink(b, c, weight);
        System.out.println(instance.toString());
    }
    
    
    
    
    /**
     * test weight method.
     */
    @Test
    public void testWeight() throws Exception{
        System.out.println("weight");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Weight weight = new Weight(3d);
        DirectedGraph instance = new DirectedGraph();
        
        instance.addNode(a);
        instance.addNode(b);
        instance.addNode(c);
        
        instance.addLink(a, b, weight);
        instance.addLink(b, c, weight);
        
        assertEquals(6.0d, instance.weight(), 0.1d);
    }
    
}
