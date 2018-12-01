/*
 * Insertion sort permette di ordinare un array.
 * Si comincia con un array vuoto, e ogni nuovo inserimento deve
 * mantenere la parte precedente ordinata. Così facendo anche l'ultimo
 * inserimento mantiene la parte sinistra ordinata e tutto l'array risulta
 * ordinato correttamente.
 */
package algoritmi;
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
    
    /**
     * costruttore
     * @param path percorso del file da aprire
     */
    public InsertionSort(ArrayList<T> array){
        this.array = array;
    }
    
    
    public void sort(){
        if(this.array.size() < 2){
            return;
        }
        
    	int minIndex = 0;
        
        //comincia a riordinare partendo dal secondo elemento dell'array
        for(int i = 1; i < this.array.size(); i++){
            recursiveSort(i, minIndex, i-1 );
            System.out.println(i + " done...");
        }
    }
    

    private void recursiveSort(int indexCurrentItem, int minIndex, int maxIndex){
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
                recursiveSort(indexCurrentItem, minIndex, midIndex-1);
                break;
            }
            case 0:{ //caso gestito negli if-else iniziali
                break;
            }
            case 1:{
                //l'elemento da ordinare e' maggiore di quello in posizione media. Confronto la parte a destra dell'indice medio
                //se confronto due indici consecutivi mi blocco e confronto, altrimenti continuo le chiamate ricorsive
                recursiveSort(indexCurrentItem, midIndex+1, maxIndex);
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
        //fixme non funziona
        T backup = this.array.get(last);
        for(int i = last; i > first; i--){
            this.array.set(i, this.array.get(i-1));
        }
        this.array.set(first, backup);
    }
    
    
}
