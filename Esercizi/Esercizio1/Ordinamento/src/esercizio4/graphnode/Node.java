/*
 * La classe Nodo per creare un grafo.
 * 
 */
package esercizio4.graphnode;

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
     * Costruttore.
     * @param content
     * @throws NodeException 
     */
    public Node(T content) throws NodeException{
        if(content == null) throw new NodeException("Content must be non null.");
        this.content = content;
        this.links = new ArrayList<Node>();
        this.weights = new ArrayList<Weight>();
    }
    
    /**
     * Costruttore parametrico.
     * @param content
     * @param links
     * @param weights 
     */
    public Node(T content,ArrayList<Node> links,ArrayList<Weight> weights) throws NodeException{
        if(content == null || (links.size() != weights.size()) ) throw new NodeException("Content must be non null.");
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
    public Node(T content,Node link,Weight weight) throws NodeException{
        if(content == null ) throw new NodeException("Content must be non null.");
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
    
    /**
     * Aggiunge un collegamento con peso ad un altro nodo.
     * @param n il nodo a cui punta il collegamento
     * @param w il peso del collegamento
     * @throws NodeException se un parametro e' null
     */
    public void addLink(Node n, Weight w) throws NodeException{
        if(n == null || w == null) throw new NodeException("Node and Content must be non null.");
        this.links.add(n);
        this.weights.add(w);
    }
    
    /**
     * Aggiunge una serie di collegamenti pesati al nodo corrente.
     * @param nodes arraylist di nodi.
     * @param weights arraylist di pesi.
     * @throws NodeException se c'e' un valore null o se nodi e pesi hanno lunghezze diverse.
     */
    public void addLink(ArrayList<Node> nodes, ArrayList<Weight> weights) throws NodeException{
        if(nodes.size() != weights.size()) throw new NodeException("Each link has to be a weight.");
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i) == null)    throw new NodeException("Node must be non null.");
            if(weights.get(i) == null)  throw new NodeException("Weight must be non null.");
            this.links.add(nodes.get(i));
            this.weights.add(weights.get(i));
        }
    }
    
    /**
     * Rimuove il collegamento al nodo specificato.
     * @param n il nodo a cui e' collegato il nodo corrente.
     */
    public void removeLink(Node n){
        int index = this.links.indexOf(n);
        this.links.remove(index);
        this.weights.remove(index);
    }
    
    /**
     * Restituisce il numero di collegamenti uscenti del nodo.
     */
    public int grade(){
        return this.links.size();
    }
    
    @Override
    public String toString() {
        String s = "";
        s += "Node: " + this.content.toString();
        for(int i = 0; i < this.links.size(); i++){
            s += "\n->" + this.links.get(i).content.toString() + " : ";
            s += this.weights.get(i).toString() + "\t";
        }
        return s;
    }
    
    
    
}
