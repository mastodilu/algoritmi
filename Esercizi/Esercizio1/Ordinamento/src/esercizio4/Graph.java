/*
 * Interfaccia di un grafo.
 */
package esercizio4;

import esercizio4.graphnode.Node;
import esercizio4.graphnode.Weight;
import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public abstract class Graph {
    /**
     * Arraylist di nodi del grafo.
     */
    protected ArrayList<Node> nodes;

    /**
     * Aggiunge il nodo al grafo.
     */
    public void addNode(Node n) throws GraphException{
        if(n == null)   throw new GraphException("Node must be non null.");
        this.nodes.add(n);
    }
    
    /**
     * Rimuove il nodo dal grafo.
     */
    public void removeNode(Node n) throws GraphException{
        if(n == null)   throw new GraphException("Node must be non null.");
        this.nodes.remove(n);
    }
    
    /**
     * Aggiunge un collegamento da 'from' a 'to' di peso 'weight'.
     * @param from
     * @param to
     * @param weight 
     */
    public abstract void addLink(Node from, Node to, Weight weight) throws GraphException;
    
    /**
     * Elimina il collegamento dal nodo 'from' al nodo 'to'.
     * @param from
     * @param to 
     */
    public abstract void removeLink(Node from, Node to) throws GraphException;
    
    /**
     * Restituisce true se il grafo e' orientato, false altrimenti.
     */
    public abstract boolean isDirected();
    
    /**
     * Restituisce il grado totale del grafo.
     */
    public int grade(){
        int total = 0;
        for(Node n : this.nodes){
            total += n.grade();
        }
        return total;
    }
    
    @Override
    public String toString() {
        String s = "";
        return s;
    }
    
    
    
}
