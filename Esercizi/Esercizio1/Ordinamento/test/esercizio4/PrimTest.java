/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio4.graphnode.Edge;
import esercizio4.graphnode.Weight;
import esercizio4.graphnode.WeightException;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class PrimTest {
    
    public PrimTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of startPrim method, of class Prim.
     */
    @Test
    public void testStartPrim() {
        System.out.println("startPrim");
        //creo nodi e archi
        String a="A",b="B",c="C",d="D",e="E",f="F";
        Weight w2, w3, w5;
        Edge[] edges = new Edge[8];
        try{
            w2 = new Weight(2);
            w3 = new Weight(3);
            w5 = new Weight(5);
            edges[0] = new Edge(a,b,w3);
            edges[1] = new Edge(b,c,w5);
            edges[2] = new Edge(a,d,w5);
            edges[3] = new Edge(c,d,w2);
            edges[4] = new Edge(c,f,w3);
            edges[5] = new Edge(d,f,w2);
            edges[6] = new Edge(d,e,w3);
            edges[7] = new Edge(e,f,w5);
            //creo un grafo
            NonDirectedGraph graph = new NonDirectedGraph();
            //popolo un grafo
            graph.addNode(a);
            graph.addNode(b);
            graph.addNode(c);
            graph.addNode(d);
            graph.addNode(e);
            graph.addNode(f);
            for(Edge edge : edges)
                graph.addEdge(edge.getFrom(), edge.getTo(), edge.getWeight());
            System.out.println(graph.toString());
            //chiamo prim
            Prim prim = new Prim(graph);
            ArrayList<Edge> result = prim.startPrim();
            printEdges(result);
            
            int totalweight = totalWeight(result);
            int expected = 15;
            assertEquals(totalweight, expected);
        }catch(WeightException ex){ System.err.println(ex.getMessage());
        }catch(GraphException ex){ System.err.println(ex.getMessage());
        }
    }
    
    
    @Test
    public void testPrim(){
        System.out.println("prim");
        //creo nodi e archi
        String a="A",b="B",c="C",d="D",e="E",f="F";
        Weight w2, w3, w5;
        Edge[] edges = new Edge[3];
        try{
            w2 = new Weight(2);
            w3 = new Weight(3);
            w5 = new Weight(5);
            edges[0] = new Edge(a,b,w3);
            edges[1] = new Edge(b,c,w5);
            edges[2] = new Edge(d,f,w2);
            //creo un grafo
            NonDirectedGraph graph = new NonDirectedGraph();
            //popolo un grafo
            graph.addNode(a);
            graph.addNode(b);
            graph.addNode(c);
            graph.addNode(d);
            graph.addNode(e);
            graph.addNode(f);
            for(Edge edge : edges)
                graph.addEdge(edge.getFrom(), edge.getTo(), edge.getWeight());
            System.out.println(graph.toString());
            //chiamo prim
            Prim prim = new Prim(graph);
            ArrayList<Edge> result = prim.startPrim();
            printEdges(result);
            
            int totalweight = totalWeight(result);
            int expected = 10;
            assertEquals(totalweight, expected);
        }catch(WeightException ex){ System.err.println(ex.getMessage());
        }catch(GraphException ex){ System.err.println(ex.getMessage());
        }
    }
    
    
    
    @Test
    public void testDirectedPrim(){
        System.out.println("startPrim directed");
        //creo nodi e archi
        String a="A",b="B",c="C",d="D",e="E",f="F";
        Weight w2, w3, w5;
        Edge[] edges = new Edge[8];
        try{
            w2 = new Weight(2);
            w3 = new Weight(3);
            w5 = new Weight(5);
            edges[0] = new Edge(a,b,w3);
            edges[1] = new Edge(b,c,w5);
            edges[2] = new Edge(a,d,w5);
            edges[3] = new Edge(c,d,w2);
            edges[4] = new Edge(c,f,w3);
            edges[5] = new Edge(d,f,w2);
            edges[6] = new Edge(d,e,w3);
            edges[7] = new Edge(e,f,w5);
            //creo un grafo
            DirectedGraph graph = new DirectedGraph();
            //popolo un grafo
            graph.addNode(a);
            graph.addNode(b);
            graph.addNode(c);
            graph.addNode(d);
            graph.addNode(e);
            graph.addNode(f);
            for(Edge edge : edges)
                graph.addEdge(edge.getFrom(), edge.getTo(), edge.getWeight());
            System.out.println(graph.toString());
            //chiamo prim
            Prim prim = new Prim(graph);
            ArrayList<Edge> result = prim.startPrim();
            printEdges(result);
            
            int totalweight = totalWeight(result);
            int expected = 18;
            assertEquals(totalweight, expected);
        }catch(WeightException ex){ System.err.println(ex.getMessage());
        }catch(GraphException ex){ System.err.println(ex.getMessage());
        }
    }
    
    
    private int totalWeight(ArrayList<Edge> a){
        int total = 0;
        for(Edge e : a){
            total += e.getWeight().getWeight();
        }
        return total;
    }
    
    
    private void printEdges(ArrayList<Edge> a){
        String s = "";
        for(Edge e : a){
            s += e.toString()+"\n";
        }
        System.out.println(s);
    }
    
}
