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
import esercizio4.graphnode.Node;
import esercizio4.graphnode.NodeException;
import esercizio4.graphnode.Weight;
import esercizio4.graphnode.WeightException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Prim {
    private Graph graph;
    private HashMap<Node, Integer> visited;
    private MinHeap minh;
    private HashMap<Node, Node> minSpanninTree;
    
    public Prim(Graph g){
        this.graph = g;
        visited = new HashMap<Node, Integer>();
        minSpanninTree = new HashMap<Node, Node>();
        minh = new MinHeap();
    }
    
    public ArrayList<Node> startPrim(){
        ArrayList<Node> result = new ArrayList<Node>();
        for(Node n : graph.nodes){              // per ogni nodo del grafo
            if(!this.visited.containsKey(n)){   // non ancora visitato
                this.visited.put(n,1);          // aggiungilo ai visitati
                addLinkToHeap(n);
                findNextLink();
            }
        }
        return result;
    }
    
    
    private void findNextLink(Node ){
        //finche' ci sono nodi in minh
        //estrai il primo
        //se punta a nodo non visitato
            // aggiungi a visited
            // salva l'arco
        while(minh.size() > 0){
            try{
                Node node = (Node)minh.heapExtract().getContent();
                for(Node link : node.getLinks()){
                    if(link)
                }
            }catch(IndexOutOfHeapException e){
                System.err.println(e.getMessage());
            }
            
        }
    }
    
    
    /**
     * Salva una copia del nodo senza i collegamenti superflui.
     * @param node il nodo che viene copiato.
     */
    public void saveToVisited(Node node){
        try{
            Node n = new Node(node.getContent());
            this.visited.put(n, 1);
        }catch(NodeException e){
            System.err.println(e.getMessage());
        }
    }
    
    
    /**
     * Inserisce nel minheap ogni nodo che non punta a nodi gia' visitati
     * @param n 
     */
    private void addLinkToHeap(Node n){
        int len = n.getLinks().size();
        for(int i = 0; i < len; i++){   // per ogni arco del nodo
            try{
                Node node = new Node(n.getContent());
                Node link = (Node)n.getLinks().get(i);
                node.addLink(node, new Weight(1));
                if(!this.visited.containsKey(node)){ // se non causa cicli
                    Weight w = (Weight)n.getWeights().get(i);
                    minh.heapInsert(// inserisci l'arco nel minheap
                        new HeapElement(n,w.getWeight())
                        ); 
                }
            }catch(NodeException e){
                System.err.println(e.getMessage());
            }catch(NullContentException e){
                System.err.println(e.getMessage());
            }catch(WeightException e){
                System.err.println(e.getMessage());
            }

        }
    }
}
