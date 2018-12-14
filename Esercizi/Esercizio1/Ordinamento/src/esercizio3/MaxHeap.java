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
