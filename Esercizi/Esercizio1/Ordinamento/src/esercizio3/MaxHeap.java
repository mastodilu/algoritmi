/*
 * Implementazione di un max heap che estende la classe astratta Heap.
 */
package esercizio3;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class MaxHeap extends Heap{

    /**
     * Confonta i due elementi passati come parametri e restituisce quello di
     * priorita' maggiore, cioe' quello che si muove verso l'alto nello heap.
     * 
     * L'elemento di priorita' maggiore e' quello il cui valore di priorita'
     * e' piu' alto.
     * A parita' di priorita' si confronta il contenuto.
     * 
     * @param first 
     * @param second
     * @return l'elemento di priorita' maggiore.
     */
    @Override
    public HeapElement comparePriority(HeapElement first, HeapElement second) {
        
        //priorita'
        if(first.getPriority() > second.getPriority() )
            return first;
        if(first.getPriority() < second.getPriority() )
            return second;
        
        //contenuto    
        switch(first.getContent().compareTo(second.getContent())){
            case -1:
                return second;
            case 0:
            case 1:
                return first;
            default:
                System.err.println("Cannot compare content of heap elements.");
                return null;
        }
        
    }
    
}
