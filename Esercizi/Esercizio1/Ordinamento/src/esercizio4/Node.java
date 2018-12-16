/*
 * La classe Nodo per creare un grafo.
 * 
 * 
 * 
 * 
 * 
 * 
 */
package esercizio4;

import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Node<T> {
    /**
     * Elenco di nodi a cui e' collegato questo nodo.
     */
    private ArrayList<Node> links;
    /**
     * Elenco di pesi dei collegamenti.
     * Ogni collegamento di indice i in 'links' ha il suo relativo
     * peso allo stesso indice in 'weights'.
     */
    private ArrayList<Weight> weights;
    /**
     * Contenuto del nodo.
     */
    private T content;
    
    /**
     * Costruttore parametrico.
     * @param content
     * @param links
     * @param weights 
     */
    public Node(T content,ArrayList<Node> links,ArrayList<Weight> weights){
        this.links = links;
        this.weights = weights;
        this.content = content;
    }
    
    /**
     * Costruttore parametrico.
     * @param content
     * @param link
     * @param weight 
     */
    public Node(T content,Node link,Weight weight){
        this.links = new ArrayList<Node>();
        this.links.add(link);
        this.weights = new ArrayList<Weight>();
        this.weights.add(weight);
        this.content = content;
    }
    
    public ArrayList<Node> getLinks(){
        return this.links;
    }
    
    public ArrayList<Weight> getWeights(){
        return this.weights;
    }
    
    public T getContent(){
        return this.content;
    }
}
