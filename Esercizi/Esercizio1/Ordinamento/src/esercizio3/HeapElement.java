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
    private T content;
    private int priority;
    
    public HeapElement(T label, int priority){
        this.content = label;
        this.priority = priority;
    }
    
    public HeapElement(T label){
        this.content = label;
        this.priority = 0;
    }
    
    protected void updatePriority(int priority){
        this.priority = priority;
    }
    
    public T getContent(){
        return this.content;
    }
    
    public int getPriority(){
        return this.priority;
    }
    
    
}
