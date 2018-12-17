/*
 * Singolo elemento che compone la coda Heap.
 * Il parametro T deve implementare l'interfaccia Comparable
 * altrimenti non e' possibile calcolare la priorita' correttamente.
 */
package esercizio3;

import esercizio3.heapelementexceptions.NullContentException;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class HeapElement<T extends Comparable> {
    private T content;
    private Double priority;
    
    public HeapElement(T content, Double priority) throws NullContentException{
        if(content == null)   throw new NullContentException();
        this.content = content;
        this.priority = priority;
    }
    
    public HeapElement(T content) throws NullContentException{
        if(content == null)   throw new NullContentException();
        this.content = content;
        this.priority = 0d;
    }
    
    /**
     * Aggiorna il valore priorita' dell'istanza corrente.
     * @param priority 
     */
    protected void updatePriority(Double priority){
        this.priority = priority;
    }
    
    public T getContent(){
        return this.content;
    }
    
    public Double getPriority(){
        return this.priority;
    }
    
    /**
     * Confronta due heap element.
     * @param other lo heap element con cui confrontare l'istanza corrente.
     * @return true se hanno uguale contenuto e priorita'; false altrimenti.
     */
    public boolean isEqualTo(HeapElement other){
        return (this.content.compareTo(other.content) == 0)
                && java.lang.Double.compare(this.priority,other.priority) == 0;
    }
    
    
    @Override
    public String toString(){
        return content.toString() + " (" + priority + ")";
    }
    
    
}
