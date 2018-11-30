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
        }
    }
    

    private void recursiveSort(int indexCurrentItem, int minIndex, int maxIndex){
        int midIndex = (int)((minIndex + maxIndex)/2); //prende la parte intera
        T currentItem = this.array.get(indexCurrentItem);
        T midItem = this.array.get(midIndex);
        
        if(currentItem.compareTo(this.array.get(minIndex)) < 0){ // minore del minimo
            this.array.remove(indexCurrentItem);
            this.array.add(minIndex, currentItem);
        }
        else if(currentItem.compareTo(this.array.get(maxIndex)) > 0){ // maggiore del massimo
            this.array.remove(indexCurrentItem);
            this.array.add(maxIndex + 1, currentItem);
        }
        else if(currentItem.compareTo(midItem) == 0){ // uguale al medio
            this.array.remove(indexCurrentItem);
            this.array.add(midIndex, currentItem);
        }
        else switch(currentItem.compareTo(midItem)){
            case -1:{
//                this.printArray(indexCurrentItem);
//                System.out.println("case -1 min " + minIndex + " mid " + midIndex + " max " + maxIndex + " item " + indexCurrentItem);
                //l'elemento da ordinare e' minore di quello in posizione media. Confronto la parte a sinistra dell'indice medio
                recursiveSort(indexCurrentItem, minIndex, midIndex-1);
                break;
            }
            case 0:{ //caso gestito negli if-else iniziali
                break;
            }
            case 1:{
//                this.printArray(indexCurrentItem);
//                System.out.println("case +1 min " + minIndex + " mid " + midIndex + " max " + maxIndex + " item " + indexCurrentItem);
                //l'elemento da ordinare e' maggiore di quello in posizione media. Confronto la parte a destra dell'indice medio
                //se confronto due indici consecutivi mi blocco e confronto, altrimenti continuo le chiamate ricorsive
                recursiveSort(indexCurrentItem, midIndex+1, maxIndex);
                break;
            }
            default:{
                //...
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
    
    
    
}
