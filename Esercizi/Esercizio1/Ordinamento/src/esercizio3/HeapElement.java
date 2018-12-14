/*
 * Singolo elemento che compone la coda Heap.
 * Il parametro T deve implementare l'interfaccia Comparable
 * altrimenti non e' possibile calcolare la priorita' correttamente.
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
    
    /**
     * Aggiorna il valore priorita' dell'istanza corrente.
     * @param priority 
     */
    protected void updatePriority(int priority){
        this.priority = priority;
    }
    
    public T getContent(){
        return this.content;
    }
    
    public int getPriority(){
        return this.priority;
    }
    
    /**
     * Confronta due heap element.
     * @param other lo heap element con cui confrontare l'istanza corrente.
     * @return true se hanno uguale contenuto e priorita'; false altrimenti.
     */
    public boolean isEqualTo(HeapElement other){
        return this.content == other.content && this.priority == other.priority;
    }
    
    
    @Override
    public String toString(){
        return content.toString() + " (" + priority + ")";
    }
    
    
}
