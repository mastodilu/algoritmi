/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class HeapElement<T extends Comparable> {
    private T label;
    private int priority;
    
    public HeapElement(T label, int priority){
        this.label = label;
        this.priority = priority;
    }
    
    public HeapElement(T label){
        this.label = label;
        this.priority = 0;
    }
    
    protected void updatePriority(int priority){
        this.priority = priority;
    }
    
    
}
