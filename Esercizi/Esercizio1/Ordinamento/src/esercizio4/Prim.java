/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio3.HeapElement;
import esercizio3.MinHeap;
import esercizio3.heapelementexceptions.NullContentException;
import esercizio3.heapexceptions.IndexOutOfHeapException;
import esercizio4.graphnode.Edge;
import esercizio4.graphnode.Weight;
import esercizio4.graphnode.WeightException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Prim<T extends Comparable<T>> {
    
    private ArrayList<Edge> edges;
    private ArrayList<T> nodes;
    private ArrayList<Edge> visitedEdges;
    private HashMap<T, Integer> visitedNodes;
    private MinHeap minh;
    
    
    
    public Prim(NonDirectedGraph g){
        initPrim(g.edges, g.nodes);
    }
    
    public Prim(DirectedGraph g){
        initPrim(g.edges, g.nodes);
    }
    
    private void initPrim(ArrayList<Edge> edges, ArrayList<T> nodes){
        edges = new ArrayList<Edge>();
        nodes = new ArrayList<T>();
        visitedEdges = new ArrayList<Edge>();
        visitedNodes = new HashMap<T, Integer>();
        minh = new MinHeap();
        
        copyArrayListEdges(edges);
        copyArrayListNodes(nodes);
    }
    
    
    public ArrayList<Edge> getResult(){
        return this.visitedEdges;
    }
    
    
    private void copyArrayListEdges(ArrayList<Edge> al){
        for(Edge e : al){
            this.edges.add(e);
        }
    }
    
    private void copyArrayListNodes(ArrayList<T> al){
        for(T t : al){
            this.nodes.add(t);
        }
    }
    
    public ArrayList<Edge> startPrim(){
        for(T t : this.nodes){                     // per ogni nodo del grafo
            if(!this.visitedNodes.containsKey(t)){ // non ancora visitato
                this.visitedNodes.put(t,1);        // aggiungilo ai visitati
                exploreEdges(t);                  // esplora i suoi archi
            }
            
            while(findNextEdge()){
            // true se ci sono archi da visitare; false se e' terminata la componente connessa.
            //  --> se ci sono altri nodi non esplorati allora ci sono altre componenti connesse
                T nextNode = (T)this.visitedEdges.get(this.visitedEdges.size()-1).getTo();
                exploreEdges(nextNode); // esplora gli archi
            }
        }
        return this.visitedEdges;
    }
    
    
    /**
     * Estrae il nodo minimo che punta a nodi inesplorati.
     * Il nuovo nodo trovato viene salvato in visitedNodes e 
     * l'arco usato per raggiungere il nuovo nodo viene salvato in visitedEdges
     * @return true se trova un nuovo arco, false altrimenti. Se restituisce false
     * e ci sono nodi inesplorati allora ci sono piu' componenti connesse.
     */
    private boolean findNextEdge(){
        boolean stop = false;
        while(minh.size() > 0 && !stop){ //controlla se puo' estrarre dallo heap
            try{
                Edge e = (Edge)minh.heapExtract().getContent(); //estrae il primo arco
                //se il nodo raggiunto con questo arco non e' contenuto nei nodi visitati
                if(!this.visitedNodes.containsKey(e.getTo())){
                    this.visitedNodes.put((T)e.getTo(), 1);// aggiungi a visited
                    this.visitedEdges.add(e);// salva l'arco
                    stop = false;
                }
            }catch(IndexOutOfHeapException e){
                System.err.println(e.getMessage());
            }
            
        }
        return stop;
    }
    
    
    /**
     * Inserisce nel minheap ogni arco che non punta a nodi gia' visitati.
     * Gli archi uscenti da 't' hanno il valore 'from' che corrisponde a 't'.
     * @param t Il nodo di partenza.
     */
    private void exploreEdges(T t){
        for(Edge e : this.edges){
            if(e.getFrom().compareTo(t) == 0){ //prende gli archi uscenti dal nodo indicato
                try{
                    HeapElement hpel = new HeapElement(e, e.getWeight());
                    minh.heapInsert(hpel);
                }catch(NullContentException ex){ System.err.println(ex.getMessage());}
            }
        }
    }
}
