/*
 * Questa class permette di ordinare un array applicando una versione di
 * insertionsort lievemente modificata.
 * L'arraylist analizzato e' "array", sul quale viene applicato un algoritmo
 * insertionsort modificato per essere piu' efficiente nel caso di array
 * non ordinati in partenza. In particolare la posizione in cui inserire
 * l'elemento analizzato nella parte sinistra viene trovata con un approccio
 * divide et impera.
 */
package esercizio1.algoritmi;
import java.util.ArrayList;

/**
 *
 * @author MatteoDiLucchio
 */
public class InsertionSort<T extends Comparable>{
    /**
     * array disordinato
     */
    ArrayList<T> array;
    

    public InsertionSort(ArrayList<T> array){
        this.array = array;
    }
    
    /**
     * sort in ordine crescente, dal piu' basso al piu' alto
     */
    public void sortAscending(){
        if(this.array.size() < 2){
            return;
        }
        
    	int minIndex = 0;
        int onePercent = 0, percentage = 1, done = 1;
        if(this.array.size() > 99)
            onePercent = this.array.size() / 100;
        
        //comincia a riordinare partendo dal secondo elemento dell'array
        for(int i = 1; i < this.array.size(); i++){
            recursiveSortAscending(i, minIndex, i-1 );
            done++;
            if(done == onePercent){
                System.out.println(percentage++ + "% done");
                done = 0;
            }
        }
    }
    
    
    /**
     * sort in ordine decrescente, dal piu' grande al piu' piccolo
     */
    public void sortDescending(){
        if(this.array.size() < 2){
            return;
        }
        
        int minIndex = 0;
        int onePercent = 0, percentage = 1, done = 1;
        if(this.array.size() > 99)
            onePercent = this.array.size() / 100;
        
        //comincia a riordinare partendo dal secondo elemento dell'array
        for(int i = 1; i < this.array.size(); i++){
            recursiveSortDescending(i, minIndex, i-1 );
            done++;
            if(done == onePercent){
                System.out.println(percentage++ + "% done");
                done = 0;
            }
        }
            
    }
    
    
    /**
     * insertion sort ricorsivo per ottimizzare i tempi di esecuzione
     * @param indexCurrentItem posizione dell'elemento da inserire nella parte ordinata
     * @param minIndex indice minimo della porzione di array ordinato in cui cercare
     * @param maxIndex indice massimo della porzione di array ordinato in cui cercare
     */
    private void recursiveSortAscending(int indexCurrentItem, int minIndex, int maxIndex){
        int midIndex = (int)((minIndex + maxIndex)/2); //prende la parte intera
        T currentItem = this.array.get(indexCurrentItem);
        T midItem = this.array.get(midIndex);
        
        if(currentItem.compareTo(this.array.get(minIndex)) < 0){ // minore del MINIMO
            swapInRange(minIndex, indexCurrentItem);
        }
        else if(currentItem.compareTo(this.array.get(maxIndex)) > 0){ // maggiore del MASSIMO
            swapInRange(maxIndex + 1, indexCurrentItem);
        }
        else if(currentItem.compareTo(midItem) == 0){ // uguale al medio
            swapInRange(midIndex, indexCurrentItem);
        }
        else switch(currentItem.compareTo(midItem)){
            case -1:{
                //l'elemento da ordinare e' minore di quello in posizione media. Confronto la parte a sinistra dell'indice medio
                recursiveSortAscending(indexCurrentItem, minIndex, midIndex-1);
                break;
            }
            case 0:{ //caso gestito negli if-else iniziali
                break;
            }
            case 1:{
                //l'elemento da ordinare e' maggiore di quello in posizione media. Confronto la parte a destra dell'indice medio
                //se confronto due indici consecutivi mi blocco e confronto, altrimenti continuo le chiamate ricorsive
                recursiveSortAscending(indexCurrentItem, midIndex+1, maxIndex);
                break;
            }
            default:{
                System.err.println("You shouldn't read this.");
                break;
            }
        }//-switch
    }
    
    
    
    
    private void recursiveSortDescending(int indexCurrentItem, int minIndex, int maxIndex){
        int midIndex = (int)((minIndex + maxIndex)/2); //prende la parte intera
        T currentItem = this.array.get(indexCurrentItem);
        T midItem = this.array.get(midIndex);
        if(currentItem.compareTo(this.array.get(minIndex)) > 0){ // maggiore del primo
            swapInRange(minIndex, indexCurrentItem);
        }
        else if(currentItem.compareTo(this.array.get(maxIndex)) < 0){ // minore dell'ultimo
            swapInRange(maxIndex + 1, indexCurrentItem);
        }
        else if(currentItem.compareTo(midItem) == 0){ // uguale al medio
            swapInRange(midIndex, indexCurrentItem);
        }
        else switch(currentItem.compareTo(midItem)){
            case 1:{
                //l'elemento da ordinare e' maggiore di quello in posizione media. Confronto la parte a sinistra dell'indice medio
                recursiveSortDescending(indexCurrentItem, minIndex, midIndex-1);
                break;
            }
            case 0:{ //caso gestito negli if-else iniziali
                break;
            }
            case -1:{
                //l'elemento da ordinare e' minore di quello in posizione media. Confronto la parte a destra dell'indice medio
                recursiveSortDescending(indexCurrentItem, midIndex+1, maxIndex);
                break;
            }
            default:{
                System.err.println("You shouldn't read this.");
                break;
            }
        }//-switch
    }

    
    /**
     * stampa l'array in una riga
     * @param flagIndex indice del primo elemento della parte non ordinata
     */
    private void printArray(int flagIndex) {
        for(int i = 0; i < this.array.size(); i++){
            System.out.print(this.array.get(i).toString() + " ");
            if(i == flagIndex - 1)
                System.out.print("# ");
        }
        System.out.println();
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
