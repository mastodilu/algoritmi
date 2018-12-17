/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4.graphnode;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Edge<T extends Comparable<T>> {
    T from;
    T to;
    Weight weight;
    
    public Edge(T from, T to, Weight weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
