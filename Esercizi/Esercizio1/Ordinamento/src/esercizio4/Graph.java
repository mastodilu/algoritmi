/*
 * Interfaccia di un grafo.
 */
package esercizio4;

import esercizio4.graphnode.Node;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public interface Graph {
    /**
     * Aggiunge il nodo al grafo.
     */
    public void addNode(Node n);
    
    /**
     * Rimuove il nodo dal grafo.
     */
    public void removeNode(Node n);
    
    /**
     * Aggiunge un collegamento da 'from' a 'to' di peso 'weight'.
     * @param from
     * @param to
     * @param weight 
     */
    public void addLink(Node from, Node to, Double weight);
    
    /**
     * Elimina il collegamento dal nodo 'from' al nodo 'to'.
     * @param from
     * @param to 
     */
    public void removeLink(Node from, Node to);
    
    /**
     * Restituisce true se il grafo e' orientato, false altrimenti.
     */
    public double isDirected();
    
    /**
     * Restituisce il grado totale del grafo.
     */
    public int grade();
}
