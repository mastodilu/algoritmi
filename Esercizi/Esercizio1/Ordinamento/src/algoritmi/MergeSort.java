/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi;

import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class MergeSort<T extends Comparable>{
    
    /**
     * array disordinato
     */
    ArrayList<T> array;
    
    public MergeSort(ArrayList<T> array){
        this.array = array;
    }
    
    
    /**
     * merge sort ricorsivo
     */
    public void sort(){
        if(this.array == null)
            return;
        
        int size = this.array.size();
        if(size <= 1)
            return;
        
        mergeSort(0, size-1);
    }
    
    
    /**
     * dimezza l'array ricorsivamente
     * @param minIndex
     * @param maxIndex 
     */
    private void mergeSort(int minIndex, int maxIndex){
        System.out.println("mergesort minIndex " + minIndex + " maxIndex " + maxIndex);
        int medIndex = (int)( (minIndex + maxIndex) / 2);
        int diff = maxIndex - minIndex; // diff > 0 se c'e' piu' di un elemento nel range valutato
        if(diff > 0){
            mergeSort(minIndex, medIndex);
            mergeSort(medIndex + 1, maxIndex);
            merge(minIndex, medIndex, maxIndex);
        }
    }
    
    
    /**
     * precondizioni:
        * il sottoarray [minIndex --> medIndex] e' ordinato
        * il sottoarray [medIndex+1 --> maxIndex] e'ordinato
        * i due array sono adiacenti e separati dall'indice 'm'
     * 
     * inserisce ogni elemento dell'array di destra nella giusta posizione dell'
     * array di sinistra, tenendo a pente che i due array sono adiacenti e ordinati
     * 
     * la complessita' non e' quadratica perche' il ciclo loop interno al ciclo for
     * non re-inizializza 'leftIndex' ad ogni iterazione del ciclo for, quindi
     * il valore precedentemente acquisito viene riutilizzato
     * @param minIndex indice iniziale del primo array
     * @param medIndex indice finale del primo array
     * @param maxIndex indice finale del secondo array
     */
    private void merge(int minIndex, int medIndex, int maxIndex){
        System.out.println("merge minIndex " + minIndex + " maxIndex " + maxIndex);
        int leftIndex, rightIndex;
        leftIndex = minIndex;
        boolean stop;
        
        for(rightIndex = medIndex + 1; rightIndex <= maxIndex; rightIndex++){
            T rightElem = this.array.get(rightIndex);
            stop = false;
            while( (leftIndex < rightIndex)
                    && (stop == false) ) {
                //se l'elemento di destra e' minore dell'elemento di sinistra
                //allora lo inserisce, altrimenti incrementa l'indice
                if(rightElem.compareTo(this.array.get(leftIndex)) < 0 ){
                    this.swapInRange(leftIndex, rightIndex);
                    stop = true;
                }else{
                    leftIndex++;
                }
            }
        }
    }
    
    
    
    /**
     * equivale ad un inserimento dell'elemento di indice 'last' nell'indice 'first'
     * evitando ridimensionamenti dell'array list
     * 
     * shifta a destra di una posizione tutti gli elementi a destra
     * dell'indice 'first' quindi copia l'elemento di indice 'last'
     * nell'elemento di indice 'first'
     * 
     * @param first indice del primo elemento da shiftare
     * @param last indice dell'ultimo elemento da shiftare
     */
    private void swapInRange(int first, int last){
        T backup = this.array.get(last);
        for(int i = last; i > first; i--){
            this.array.set(i, this.array.get(i-1));
        }
        this.array.set(first, backup);
    }
}




    