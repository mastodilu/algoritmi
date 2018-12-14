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
public class MinHeap extends Heap{

    @Override
    public HeapElement comparePriority(HeapElement first, HeapElement second) {
        //priorita'
        if(second.getPriority() > first.getPriority() )
            return first;
        if(second.getPriority() < first.getPriority() )
            return second;
        
        //contenuto    
        switch(first.getContent().compareTo(second.getContent())){
            case 1:
                return second;
            case 0:
            case -1:
                return first;
            default:
                System.err.println("Cannot compare content of heap elements.");
                return null;
        }
    }
    
}
