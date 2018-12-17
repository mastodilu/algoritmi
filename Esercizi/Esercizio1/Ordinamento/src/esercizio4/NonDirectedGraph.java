/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio4.graphnode.Edge;
import esercizio4.graphnode.Weight;
import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class NonDirectedGraph <T extends Comparable<T>>{
    /**
     * Arraylist di nodi del grafo.
     */
    protected ArrayList<T> nodes;
    protected ArrayList<Edge> edges;
    
    public NonDirectedGraph(){
        this.nodes = new ArrayList<T>();
        this.edges = new ArrayList<Edge>();
    }
    
    
    /**
     * Aggiunge il nodo al grafo.
     */
    public void addNode(T t) throws GraphException{
        if(t == null)   throw new GraphException("Node must be non null.");
        this.nodes.add(t);
    }
    
    /**
     * Rimuove il nodo dal grafo.
     */
    public void removeNode(T t) throws GraphException{
        if(t == null)   throw new GraphException("Node must be non null.");
        this.nodes.remove(t);
    }

    public void addEdge(T from, T to, Weight weight) throws GraphException {
        if(from == null)  throw new GraphException("Nodes must be non null.");
        if(this.nodes.contains(from) && this.nodes.contains(to)){
            this.edges.add(new Edge(from, to, weight));
            this.edges.add(new Edge(to, from, weight));
        }
    }

    public void removeEdge(T from, T to) throws GraphException {
        if(from == null)  throw new GraphException("Nodes must be non null.");
        for(int i=0; i<this.edges.size(); i++){
            Edge e = this.edges.get(i);
            if(e.getFrom().compareTo(from) == 0 && e.getTo().compareTo(to) == 0
                    || e.getFrom().compareTo(to) == 0 && e.getTo().compareTo(from) == 0){
                this.edges.remove(i);
                i--;
            }
        }
    }
    
    
    /**
     * Restituisce il grado totale del grafo.
     */
    public int grade(){
        return this.edges.size();
    }
    
    
    /**
     * Restituisce la somma dei pesi dei collegamenti tra i nodi del grafo.
     */
    public Integer weight(){
        Integer total = 0;
        for(Edge e : this.edges)
            total += e.getWeight();
        return total;
    }

    public boolean isDirected() {
        return false;
    }
    
    
    public String toString() {
        String s = "";
        for(Edge e : this.edges)
            s +=  e.toString() + "\n";
        return s;
    }
    
    
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

}
