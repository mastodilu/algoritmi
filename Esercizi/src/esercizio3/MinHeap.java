/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3;

import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class MinHeap extends Heap{
    
    public MinHeap(ArrayList<HeapElement> elements){
        super(elements);
    }
    
    
    public MinHeap(HeapElement[] elements){
        super(elements);
    }
    
    public MinHeap(){
        super();
    }

    /**
     * Confonta i due elementi passati come parametri e restituisce quello di
     * priorita' maggiore, cioe' quello che si muove verso l'alto nello heap.
     * 
     * L'elemento di priorita' maggiore e' quello il cui valore di priorita'
     * e' piu' basso.
     * A parita' di priorita' si confronta il contenuto.
     * 
     * Se entrambi i parametri sono null allora restituisce null
     * Se first e' null restituisce second
     * Se second e' null restituisce first
     * 
     * @param first 
     * @param second
     * @return l'elemento di priorita' maggiore.
     * 
     */
    @Override
    public HeapElement prior(HeapElement first, HeapElement second) {
        //controllo valori null
        if(first == null && second == null)     return null;
        if(first == null)                       return second;
        if(second == null)                      return first;
        
        //priorita'
        if(second.getPriority() > first.getPriority() )
            return first;
        if(second.getPriority() < first.getPriority() )
            return second;
        
        //contenuto
        if(first.getContent().compareTo(second.getContent()) <= 0)
            return first;
        return second;
    }
    
}
