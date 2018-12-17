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
        this.edges = new ArrayList<Edge>();
        this.nodes = new ArrayList<T>();
        visitedEdges = new ArrayList<Edge>();
        visitedNodes = new HashMap<T, Integer>();
        minh = new MinHeap();
        copyArrayListEdges(edges);
        copyArrayListNodes(nodes);
    }
    
    
    public synchronized ArrayList<Edge> getResult(){
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
    
    public synchronized ArrayList<Edge> startPrim(){
        System.out.println("Computing Prim...");
        for(T t : this.nodes){                     // per ogni nodo del grafo
            if(!this.visitedNodes.containsKey(t)){ // non ancora visitato
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
    
    
    
    public HashMap<T, Integer> getVisitedNodes(){
        return this.visitedNodes;
    }
    
    
    /**
     * Estrae il nodo minimo che punta a nodi inesplorati se questo non causa cicli.
     * Il nuovo nodo trovato viene salvato in visitedNodes e 
     * l'arco usato per raggiungere il nuovo nodo viene salvato in visitedEdges
     * @return true se trova un nuovo arco, false altrimenti. Se restituisce false
     * e ci sono nodi inesplorati allora ci sono piu' componenti connesse.
     */
    private boolean findNextEdge(){
        boolean stop = false;
        while(minh.size() > 0 && !stop){
            try{
                Edge e = (Edge)minh.heapExtract().getContent(); //estrae il primo arco
                //se il nodo raggiunto con questo arco non e' contenuto nei nodi visitati
                if(!this.visitedNodes.containsKey(e.getTo())){//evita cicli
                    this.visitedNodes.put((T)e.getTo(), 1);// aggiungi a visited
                    this.visitedEdges.add(e);// salva l'arco
                    stop = true;
                }
            }catch(IndexOutOfHeapException e){
                System.err.println(e.getMessage());
            }
        }
        return stop;
    }
    
    
    /**
     * Inserisce nel minheap ogni arco uscente dal nodo passato come parametro.
     * Gli archi uscenti da 't' hanno il valore 'from' che corrisponde a 't'.
     * @param t Il nodo di partenza.
     */
    private void exploreEdges(T t){
        this.visitedNodes.put(t,1); // aggiunge il nodo ai nodi visitati
        for(Edge e : this.edges){
            if(e.getFrom().compareTo(t) == 0){ //prende gli archi uscenti dal nodo indicato
                try{
                    HeapElement hpel = new HeapElement(e, e.getWeight().getWeight());
                    minh.heapInsert(hpel);
                }catch(NullContentException ex){ System.err.println(ex.getMessage());}
            }
        }
    }
    
    
    /**
     * Restituisce la somma dei pesi (distanze in Km) degli archi.
     */
    public Double weight(){
        Double d = 0d;
        for(Edge e : this.visitedEdges){
            d += e.getWeight().getWeight();
        }
        return d;
    }
    
    
    
    
    @Override
    public String toString(){
        String s = "Nodes:\n";
        for(T t : this.visitedNodes.keySet())
            s += t.toString() + "\n";
        s += "Edges:\n";
        for(Edge e : this.visitedEdges){
            s += e.toString() + "\n";
        }
        return s;
    }
}
