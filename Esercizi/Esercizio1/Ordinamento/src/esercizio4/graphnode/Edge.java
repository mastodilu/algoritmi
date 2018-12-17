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
public class Edge<T extends Comparable<T>> implements Comparable<Edge>{
    private T from;
    private T to;
    private Weight weight;
    
    public Edge(T from, T to, Weight weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public T getFrom() {
        return from;
    }

    public T getTo() {
        return to;
    }

    public int getWeight() {
        return weight.getWeight();
    }
    
    public String toString(){
        return from.toString() + ""
                + " -> " + to.toString() + ""
                + " : " + weight.toString();
    }
    
    
    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo(o.weight);
    }
    
    
}
