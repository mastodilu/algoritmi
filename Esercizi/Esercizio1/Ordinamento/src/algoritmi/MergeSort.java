/*
 * Questa classe permette di eseguire mergesort sull'arraylist "array"
 * in ordine crescente o decrescente per ordinarne gli elementi contenuti
 * senza creare arraylist ausiliari.
 * La ricerca viene resa efficiente dall'approccio divide et impera, che
 * dimezza il range analizzato ad ogni iterazione, fino a quando non si puo'
 * piu' dimezzare.
 * 
 */
package algoritmi;

import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class MergeSort<T extends Comparable>{
    
    /**
     * true se l'ordinamento e' in ordine crescente, false altrimenti
     */
    private boolean ascending = false;
    
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
        
        this.ascending = true;
        mergeSort(0, size-1);
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
        
        this.ascending = false;
        mergeSort(0, size-1);
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
     * sulla prima e sulla seconda meta', per poi unirle in modo ordinato con
     * mergeAscending oppure mergeDescending a seconda del valore booleano di 'this.ascending'
     * @param minIndex indice del primo elemento del sottoarray di sinistra
     * @param maxIndex indice dell'ultimo elemento del sottoarray di destra
     */
    private void mergeSort(int minIndex, int maxIndex){
        int medIndex = (int)( (minIndex + maxIndex) / 2);
        int diff = maxIndex - minIndex; // diff > 0 se c'e' piu' di un elemento nel range valutato
        if(diff > 0){
            mergeSort(minIndex, medIndex);
            mergeSort(medIndex + 1, maxIndex);
            if(this.ascending)
                    mergeAscending(minIndex, medIndex, maxIndex);
            else    this.mergeDescending(minIndex, medIndex, maxIndex);
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




    