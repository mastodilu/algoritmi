/*
 * NB: il primo elemento dell'arraylist e' sempre un elemento null
 * che mantiene sempre vera la relazione tra un nodo e i due figli:
 *      indice nodo:    i
 *      indici figli:   2i, 2i+1
 * 

 */
package esercizio3;

import esercizio3.heapexceptions.IndexOutOfHeapException;
import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public abstract class Heap<T extends Comparable> {
    
    /**
     * elementi che compongono lo heap
     */
    private ArrayList<HeapElement> elements;
    
    /**
     * Costruttore partendo da un arraylist.
     * Il primo elemento e' sempre null per mantenere la relazione tra gli
     * indici del padre e dei figli.
     * @param elements arraylist di HeapElement.
     */
    public Heap(ArrayList<HeapElement> elements){
        this.elements = elements;
        //this.elements.add(0, new HeapElement(null)); // primo elemento null
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Costruttore partendo da un array di HeapElement.
     * Il primo elemento e' sempre null per mantenere la relazione tra gli
     * indici del padre e dei figli.
     * @param elements array di HeapElement
     */
    public Heap(HeapElement[] elements){
        this.elements = new ArrayList<HeapElement>();
        this.elements.add(new HeapElement(null));
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Costruttore senza parametri.
     * Il primo elemento e' sempre null per mantenere la relazione tra gli
     * indici del padre e dei figli.
     */
    public Heap(){
        elements = new ArrayList<HeapElement>();
        elements.add(new HeapElement(null)); // primo elemento null
    }
    
    
    /**
     * Restituisce il parent node senza rimuoverlo.
     * @param index 
     * @return
     * @throws IndexOutOfHeapException 
     */
    public HeapElement parent(int index) throws IndexOutOfHeapException{
        if(index < 2 || index >= this.elements.size())
            throw new IndexOutOfHeapException("To get the parent node"
                    + " index cannot be less than 2 or "
                    + "greater than the size of the array.");
        if(index%2 == 1) //se dispari
            index--;
        return this.elements.get(index);
    }
    
    
    public int left(int index) throws IndexOutOfHeapException{
        if(2*index >= this.elements.size())
            throw new IndexOutOfHeapException();
        return 2*index;
    }
    
    /**
     * @return l'elemento di priorita' maggiore
     */
    public HeapElement head(){
        if(elements.size() > 0)
            return elements.get(0);
        else return null;
    }

    private void shish() {
        
    }
}
