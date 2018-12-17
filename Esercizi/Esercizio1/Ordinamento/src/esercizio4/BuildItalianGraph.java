/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio4.graphnode.Weight;
import esercizio4.graphnode.WeightException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class BuildItalianGraph {
    private static final String PATH_DIST = "C:\\Users\\masto\\Documents\\MieiProgetti\\Algoritmi_file_enormi\\Esercizio4\\italian_dist_graph.csv";
    private BufferedReader br;
    private FileReader fr;
    
    /**
     * Grafo delle distanze italiane costruito dal file di input.
     */
    private NonDirectedGraph graph;
    
    public BuildItalianGraph(){
        graph = new NonDirectedGraph();
        openItalianDist();
        readInputBuildGraph();
        close();
    }
    
    
    public NonDirectedGraph getGraph(){
        return this.graph;
    }
    
    /**
     * Costruisce il grafo leggendo l'input dal file di testo.
     */
    private void readInputBuildGraph(){
        String line;
        try{
            while( (line = br.readLine()) != null){
                String[] entry = line.split(",");
                addToGraph(entry);
            }
        }catch(IOException e){
            System.err.println("Errore IO");
        }
    }
    
    
    /**
     * Aggiunge ogni entry nel grafo: due nodi (from, to) e un arco che li collega.
     * @param s array di stringhe composto da from, to, arco
     */
    private void addToGraph(String[] s){
        String from, to;
        Weight weight;
        try{
            from = s[0];
            to = s[1];
            weight = new Weight(Double.parseDouble(s[2])/1000); //m --> Km
            graph.addNode(from);
            graph.addNode(to);
            graph.addEdge(from, to, weight);
            System.out.println("Add " + from.toString() + "; " + to.toString() + "; " + weight.toString());
        }catch(WeightException ex){     System.err.println(ex.getMessage());
        }catch(GraphException ex){      System.err.println(ex.getMessage());
        }
    }
    
    
    
    /**
     * Open distances file.
     */
    private void openItalianDist(){
        try{
            fr = new FileReader(PATH_DIST);
            br = new BufferedReader(fr);
        }catch(FileNotFoundException e){
            System.err.println("Unable to open " + PATH_DIST);
            close();
        }
    }
    
    
    /**
     * Chiude lo stream per la lettura del file.
     */
    private void close(){
        try{
            br.close();
            fr.close();
        }catch(IOException e){
            System.err.println("Unable to close the stream");
        }
        System.out.println("Closed.");
    }
    
    @Override
    public String toString() {
        String s = "Nodes: " + graph.nodes.size() + "\n"
                + "Edges: " + graph.edges.size();
        return s;
    }
}
