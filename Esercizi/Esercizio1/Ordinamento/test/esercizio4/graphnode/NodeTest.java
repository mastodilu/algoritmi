/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4.graphnode;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class NodeTest {
    
    public NodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    

    

    

    /**
     * Test of addLink method, of class Node.
     */
    @Test
    public void testAddLink_Node_Weight() throws Exception {
        System.out.println("addLink");
        Node a = new Node("A");
        assertEquals(a.grade(), 0);
        Node b = new Node("B", a, new Weight(3));
        assertEquals(b.grade(), 1);
        a.addLink(b, new Weight(1));
        assertEquals(a.grade(), 1);
    }

    
    /**
     * Test of removeLink method, of class Node.
     */
    @Test
    public void testRemoveLink() throws Exception{
        System.out.println("removeLink");
        Node a = new Node("A");
        Node b = new Node("B", a, new Weight(3));
        assertEquals(b.grade(), 1);
        b.removeLink(a);
        assertEquals(b.grade(), 0);
    }

    /**
     * Test of grade method, of class Node.
     */
    @Test
    public void testGrade()throws Exception{
        System.out.println("grade");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C", a, new Weight(2));
        c.addLink(b, new Weight(3));
        c.addLink(a, new Weight(4));
        int expResult = 3;
        int result = c.grade();
        assertEquals(expResult, result);
    }

    
    /**
     * Test del metodo toString
     */
    @Test
    public void testToString() throws Exception{
        System.out.println("toString");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C", a, new Weight(2));
        c.addLink(b, new Weight(3));
        c.addLink(a, new Weight(4));
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}

