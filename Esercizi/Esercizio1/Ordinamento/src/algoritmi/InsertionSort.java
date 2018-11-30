/*
 * Insertion sort permette di ordinare un array.
 * Si comincia con un array vuoto, e ogni nuovo inserimento deve
 * mantenere la parte precedente ordinata. Così facendo anche l'ultimo
 * inserimento mantiene la parte sinistra ordinata e tutto l'array risulta
 * ordinato correttamente.
 */
package algoritmi;
import java.io.IOException;
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
     * array che contiene solo elementi ordinati
     */
    ArrayList<T> sorted;
    
    /**
     * costruttore
     * @param path del file da aprire
     */
    public InsertionSort(ArrayList<T> array){
        this.array = array;
//        sorted = new ArrayList<T>();
//        //aggiunge il primo elemento all'array ordinato come base di partenza
//        sorted.add(array.get(0));
//        array.remove(0);
    }

    /**
     * esegue l'ordinamento sul file
     */
    public void sort(){
        System.out.println("Sorting started");
        while(this.array.size() > 0){
            this.addToOrdered(this.array.get(0));
            this.array.remove(0);
        }
    }
    
    /**
     * aggiunge il parametro passato alla giusta posizione dell'array ordinato
     * @param elem elemento da aggiungere nella giusta posizione
     */
    private void addToOrdered(T elem){
        boolean added = false;
        int i;
        for(i = 0; i < this.sorted.size(); i++){
            switch(elem.compareTo(this.sorted.get(i))){
                case -1:
                case 0:{
                    //elem è minore di
                    this.sorted.add(i, elem);
                    added = true;
                    break;
                }
                case 1: //elem è maggiore di
                default:{
                }
            }
        }
        if(!added){
            this.sorted.add(i, elem);
        }
    }
    
    
    public void testSort(){
        if(this.array.size() < 2){
            return;
        }
    	int minIndex = 0;
        //comincia a riordinare partendo dal secondo elemento dell'array
        for(int i = 1; i < this.array.size(); i++){
            testRecursiveSort(i, minIndex, i-1 );
        }
    }
    

    private void testRecursiveSort(int indexCurrentItem, int minIndex, int maxIndex){
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
                this.printArray(indexCurrentItem);
                System.out.println("case -1 min " + minIndex + " mid " + midIndex + " max " + maxIndex + " item " + indexCurrentItem);
                //l'elemento da ordinare e' minore di quello in posizione media. Confronto la parte a sinistra dell'indice medio
                testRecursiveSort(indexCurrentItem, minIndex, midIndex-1);
                break;
            }
            case 0:{ //caso gestito negli if-else iniziali
                break;
            }
            case 1:{
                this.printArray(indexCurrentItem);
                System.out.println("case +1 min " + minIndex + " mid " + midIndex + " max " + maxIndex + " item " + indexCurrentItem);
                //l'elemento da ordinare e' maggiore di quello in posizione media. Confronto la parte a destra dell'indice medio
                //se confronto due indici consecutivi mi blocco e confronto, altrimenti continuo le chiamate ricorsive
                testRecursiveSort(indexCurrentItem, midIndex+1, maxIndex);
                break;
            }
            default:{
                //...
                System.err.println("You shouldn't read this.");
                break;
            }
        }//-switch
    }

    private void printArray(int flagIndex) {
        for(int i = 0; i < this.array.size(); i++){
            System.out.print(this.array.get(i).toString() + " ");
            if(i == flagIndex - 1)
                System.out.print("# ");
        }
        System.out.println();
    }
    
    
    
}
