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
     * array disordinato da riordinare
     */
    ArrayList<T> array;
    
    public MergeSort(ArrayList<T> array){
        this.array = array;
    }
    
    
    /**
     * merge sort ricorsivo in ordine crescente
     */
    public void sortAscending(){
        if(this.array == null)
            return;
        
        int size = this.array.size();
        if(size <= 1)
            return;
        
        mergeSortAscending(0, size-1);
    }
    
    
    
    /**
     * merge sort ricorsivo in ordine decrescente
     */
    public void sortDescending(){
        if(this.array == null)
            return;
        
        int size = this.array.size();
        if(size <= 1)
            return;
        
        mergeSortDescending(0, size-1);
    }
    
    
    
    /**
     * dimezza l'array ricorsivamente e volta per volta chiama il metodo mergesortDescending
     * sulla prima e sulla seconda meta', per poi unirle in modo ordinato col metodo mergeDescending
     * @param minIndex
     * @param maxIndex 
     */
    private void mergeSortDescending(int minIndex, int maxIndex){
        int medIndex = (int)( (minIndex + maxIndex) / 2);
        int diff = maxIndex - minIndex; // diff > 0 se c'e' piu' di un elemento nel range valutato
        if(diff > 0){
            mergeSortDescending(minIndex, medIndex);
            mergeSortDescending(medIndex + 1, maxIndex);
            mergeDescending(minIndex, medIndex, maxIndex);
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
    private void mergeDescending(int minIndex, int medIndex, int maxIndex){
        int leftIndex, rightIndex;
        leftIndex = minIndex;
        boolean stop;
        
        for(rightIndex = medIndex + 1; rightIndex <= maxIndex; rightIndex++){
            T rightElem = this.array.get(rightIndex);
            stop = false;
            while( (leftIndex < rightIndex)
                    && (stop == false) ) {
                //se l'elemento di destra e' maggiore dell'elemento di sinistra
                //allora lo inserisce, altrimenti incrementa l'indice
                if(rightElem.compareTo(this.array.get(leftIndex)) > 0 ){
                    this.swapInRange(leftIndex, rightIndex);
                    stop = true;
                }else{
                    leftIndex++;
                }
            }
        }
    }
    
    
    /**
     * dimezza l'array ricorsivamente e volta per volta chiama il metodo mergesort
     * sulla prima e sulla seconda meta', per poi unirle in modo ordinato col metodo mergeAscending
     * @param minIndex
     * @param maxIndex 
     */
    private void mergeSortAscending(int minIndex, int maxIndex){
        int medIndex = (int)( (minIndex + maxIndex) / 2);
        int diff = maxIndex - minIndex; // diff > 0 se c'e' piu' di un elemento nel range valutato
        if(diff > 0){
            mergeSortAscending(minIndex, medIndex);
            mergeSortAscending(medIndex + 1, maxIndex);
            mergeAscending(minIndex, medIndex, maxIndex);
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
    private void mergeAscending(int minIndex, int medIndex, int maxIndex){
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




    